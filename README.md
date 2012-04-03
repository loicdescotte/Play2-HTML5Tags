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

