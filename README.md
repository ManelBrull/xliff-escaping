<h1> Xliff-escaping </h1>

<h3> Introduction <h3>
 XLIFF is an XML format for communication with trnaslation agencies.
We can put all the bits of texts that we want translated into an xliff document and send it to the translation agency.
They can read it with their tools, put in the trnasalted texts, and send us back another xliff document. A standart format ensures that different translation tools are interoperable.
Inside an xliff document, the translatable text are sent inside source elements.

Often, we are translating web pages, and the translatable texts include some html elements. The problem is if we find html tags inside a source element. We cannot hace html elements inside a source tag because they would break the xliff format and also confuse the human trnaslator who does not know html.

This code recieves a String and returns a String. The received String is a small text that may contain some html elements and a source tag to translate. The returned stringshould be the same, with the html elements properly escaped for inclusion in an xliff source element.

* We assume that the text is a correct html snippet with source tags.
* All openings tags have matching closing tag.
* There are no single tags.
* The elements may be nested.
* The elements have no atributes.

The output should be correct according to XLIFF1.2. Here is everything you have to know:

* bpt escapes the opening tag.
* ept escapes the closing tag.
* Both have an id attribute which should have a unique arbitrary value.
* A pair of bpt and ept that escape a pair of opening and closing html tags have rid attribute with the same value.

<h3>Technical</h3>
The solution consists on a combination of backward recursivity and divide and conquer.
* We use backward recursivity to look for nested tags and escape them. We look for the deepest tag and we convert it. Then we apply the change to the others tags recursively.
* We use divide and conquer in case elements are at the same level. We take the first opening and closing tag and solve them. Then we move to the rest recursively.

This logic is implemented in the method parseBlock of the class XLIFFwithHTML.

The id attribute for bpt and ept tags are generated from 0..n. The first escaped tag will have the 0 id and the n escaped tag will have the n id. It's the same for each rid attribute, 0 for the first pair and n for the n pair.

<h3>Extras</h3>
* The code works for arbitrary html paired tags.

<h3> Future Work </h3>
* This code only works if the first String contains a source tag. That has been done in case a String could have multiple source tags, just in case it is not needed to translate everything. However, this code only works if there are only one pair of source tags.
* This code heavily relies on tags syntax like ">", "<", "</*>", etc. If one of that symbols is misplaced, like point something doing "-->" or "<--" the code will crash. 
