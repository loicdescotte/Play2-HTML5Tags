# HTML5 validation tags module for Play 2.0

This tags add client side valdiation attributes (e.g required, max|min lentgh...).

Attributes are generared from the constraints defined on the model (e.g. "required" contraint on a field). 

They can generate several kinds all inputs : 

 * text
 * number
 * more to come (tel, date, range, color...)

Examples :

 * @text(form("name"), 'label -> "Your name : ")
 * @number(form("age"), 'label -> "Your age : ")

If your model contains this :

    @Constraints.Required
    public String author;
    
    public Integer age;
 
 The generated output will be : 
 
    <input id="author" name="author" value="" label="Your name : " type="text" required>
    <input id="age" name="age" value="" label="Your age : " type="number">
    
Then the browser will check that the `author` field is not empty and the `age` input is a number, before sending to server. 

