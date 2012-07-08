# HTML5 input tags module for Play 2.0

This tags add client side validation attributes (required, max|min length) and formats (date, number, email...) to Play 2.0 templates.

Attributes are generared from the constraints defined on the model, e.g. `Required` constraint on a field. 

They can generate several kinds of input : 

 * text
 * email (validates that it's an email pattern)
 * tel (enables numeric keypad on mobile)
 * number (enables numeric keyboard on mobile, and specific input on other browsers) 
 * date (enables date selection)
 * url (validates that it's an url pattern)
 * search (enables special display for this kind of input)
 * password 

Example :

    @import html5.tags.html._

    @text(form("name"), 'label -> "Your name : ")
    @number(form("age"), 'label -> "Your age : ") 

If your model contains this :

    @Constraints.Required
    @Constraints.MaxLength(10)
    public String name;
    
    public Integer age;
 
 The generated output will be : 
 
    <input type="text" id="name" name="name" value="" label="Your name : " required maxlength="10">
    <input type="number" id="age" name="age" value="" label="Your age : ">
    
Then the browser will check that the `name` field is not empty and the `age` input is a number, before sending to server. 
It will also limit the length of the `name` input.

The `text` tag is able to change the input type if an email constraint is found on the model.
Using this model field :

    @Constraints.Email
    public String contactMail;
     
And this tag :
  
    @text(form("contactMail"), 'label -> "Your mail : ")

The generated output will be :

    <input type="email" id="contactMail" name="contactMail" value="">

And the browser will check that the field contains an email address.

Note : you can check browsers compatibility for this new attributes [here] (http://wufoo.com/html5/)


## A few examples with pictures

Email validation :

![Image](http://wufoo.com/html5/images/email-supported-firefox4b12.png)

Telephone number keyboard (on Safari mobile) :

![Image](http://wufoo.com/html5/images/tel-mobsafari-supported.png)

## How to install it

As the Play2 public module respository is not available yet, you will have to install it in your own repository.
In the `Play2-HTML5Tags` folder, run `play`, then run `publish-local`.

In your application, add this configuration to the `project/Build.scala` file :


    val appDependencies = Seq(
      "com.loicdescotte.coffeebean" % "html5tags_2.9.1" % "1.0-SNAPSHOT"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
    	resolvers += "Local Play Repository" at "file://your-path-to-Play2/repository"
    )

	
