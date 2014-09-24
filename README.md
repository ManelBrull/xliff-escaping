<h1> Xliff-escaping </h1>
* * * 
<h3> Introduction <h3>
<p> XLIFF is an XML format for communication with trnaslation agencies.</p>
<p> We can put all the bits of texts that we want translated into an xliff document and send it to the translation agency.
They can read it with their tools, put in the trnasalted texts, and send us back another xliff document. A standart format ensures
that different translation tools are interoperable </p>
<p> Inside an xliff document, the translatable text are sent inside <source> elements. So if we want them to transalte "Hello world", the xliff document will contain: </p>

    <source>Hello world\</source> 
    
<p> Often, we are translating web pages, and the translatable texts include some html elements, like </p>

    I'm <b> really</b> sure about this.
    
<p> If we just put it into a source element, we'd get</p>

    <source>I'm <b> really</b> sure about this.</source>
    
<p>That is wrong. We cannot hace html elements inside a source tag because they would break the xliff format and also confuse the human trnaslator who does not know html </p>

<p> This code recieves a String and returns a String. The received String is a small text that may contain some html elements and a source tag to translate. The returned stringshould be the same, with the html elements properly escaped for inclusion in an xliff source element</p>

* We assume that the text is a correct html snippet with source tags.
* All openings tags have matching closing tag.
* There are no single tags
* The elements may be nested
* The elements have no atributes

<p> The output should be correct according to XLIFF1.2. Here is everything you have to know: </p>

* bpt escapes the opening tag.
* ept escapes the closing tag.
* Both have an id attribute which should have a unique arbitrary value.
* A pair of bpt and ept that escape a pair of opening and closing html tags have rid attribute with the same value.

<h3>Technical</h3>
<p> The solution consists on a combination of backward recursivity and divide and conquer.</p>
* We use backward recursivity to look for nested tags and escape them.
* We use divide and conquer in case elements are at the same level.
