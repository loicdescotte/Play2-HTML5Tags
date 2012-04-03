# HTML5 validation tags for Play 2.0

This tags add client side valdiation attributes (e.g required, max|min lentgh...)
This attributes are generared from the contraints defined on the model (e.g. "required" contraint on a field)
Thay can generate several kinds all inputs : 

 * text
 * number
 * more to come (tel, date, range, color...)

Examples :
@text(form("name"), 'label -> "Your name : ")
@number(form("age"), 'label -> "Your age : ")

