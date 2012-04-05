# HTML5 input tags module for Play 2.0

This tags add client side valdiation attributes (e.g required, max|min lentgh...) and specific input fields (date, telephone number...) to Play 2.0 templates.

Attributes are generared from the constraints defined on the model (e.g. `@Required` contraint on a field). 

They can generate several kinds all inputs : 

 * text
 * number
 * more to come (tel, date, range, color...)

Examples :

 * @text(form("name"), 'label -> "Your name : ")
 * @number(form("age"), 'label -> "Your age : ")

If your model contains this :

    @Constraints.Required
    public String name;
    
    public Integer age;
 
 The generated output will be : 
 
    <input type="text" id="name" name="name" value="" label="Your name : " required>
    <input type="number" id="age" name="age" value="" label="Your age : ">
    
Then the browser will check that the `author` field is not empty and the `age` input is a number, before sending to server. 

