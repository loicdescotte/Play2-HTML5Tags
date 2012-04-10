# HTML5 input tags module for Play 2.0

This tags add client side validation attributes (e.g required, regex pattern, max length...) and specific input fields (date, telephone number, color...) to Play 2.0 templates.

Attributes are generared from the constraints defined on the model, e.g. `Required` constraint on a field. 

They can generate several kinds all inputs : 

 * text
 * email (validates that it's an email pattern)
 * tel (enables numeric keypad on mobile)
 * number (enables numeric keyboard on mobile, and specific input on other browsers) 
 * date, range, color... (coming soon)

Examples :

 * @text(form("name"), 'label -> "Your name : ")
 * @number(form("age"), 'label -> "Your age : ") 

If your model contains this :

    @Constraints.Required
    @Constraints.MaxLength(10)
    public String name;
    
    public Integer age;
 
 The generated output will be : 
 
    <input type="text" id="name" name="name" value="" label="Your name : " required maxlength="10">
    <input type="number" id="age" name="age" value="" label="Your age : ">
    
Then the browser will check that the `author` field is not empty and the `age` input is a number, before sending to server. 
It will also limit the length of the `author` input.

Note : you can check browsers compatibility for this new attributes [here] (http://wufoo.com/html5/)