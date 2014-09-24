<h1> Xliff-escaping </h1>
* * * 
<h3> Introduction <h3>
<p> XLIFF is an XML format for communication with trnaslation agencies.</p>
<p> We can put all the bits of texts that we want translated into an xliff document and send it to the translation agency.
They can read it with their tools, put in the trnasalted texts, and send us back another xliff document. A standart format ensures
that different translation tools are interoperable </p>
<p> Inside an xliff document, the translatable text are sent inside <source> elements. So if we want them to transalte "Hello world", the xliff document will contain: </p>
<pre><code> <source>Hello world</source></code></pre>
