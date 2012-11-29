# HTML5 input tags module for Play 2
## for Java and Scala

This tags add client side validation attributes (required, max|min length, ...) and formats (date, number, email, ...) to Play 2 templates.

Attributes are generared from the constraints defined in the model or in a form mapping. 

They can generate several kinds of input : 

 * text
 * email (validates that it's an email pattern)
 * tel (enables numeric keypad on mobile)
 * number (enables numeric keyboard on mobile, and specific input on other browsers) 
 * date (enables date selection)
 * url (validates that it's an url pattern)
 * search (enables special display for this kind of input)
 * password 
 * custom formats (using regular expression patterns)

Example :

    @import html5.tags.html._

    @text(form("name"), 'label -> "Your name : ")
    @number(form("age"), 'label -> "Your age : ") 

If your form mapping is defined like this (Scala) :

    mapping(          
      "name" -> nonEmptyText(maxLength=10),
      "age" -> number
    )

Or if your model contains this (Java) :

    @Constraints.Required
    @Constraints.MaxLength(10)
    public String name;
    
    public Integer age;
 
 The generated output will be : 
 
    <input type="text" id="name" name="name" value="" label="Your name : " required maxlength="10">
    <input type="number" id="age" name="age" value="" label="Your age : ">
    
Then the browser will check that the `name` field is not empty and the `age` input is a number, before sending to server. 
It will also limit the length of the `name` input.

Note : you can check browsers compatibility for this new attributes on [wufoo] (http://wufoo.com/html5/).

## A few examples with pictures

Email validation :

![Image](http://wufoo.com/html5/images/email-supported-firefox4b12.png)

Telephone number keyboard (on Safari mobile) :

![Image](http://wufoo.com/html5/images/tel-mobsafari-supported.png)

## Avalaible tags and formats

You can use the following tags : 

 * @date
 * @email
 * @number
 * @password
 * @search
 * @tel
 * @text
 * @url

And the following constraint values on models/mappings :

 * required (or nonEmpty or nonEmptyText)
 * maxLength
 * minLength
 * max
 * min
 * pattern

## Magic tag

The `text` tag is able to change the input type if a specific format is detected.

For example, using the email constraint :

    @Constraints.Email
    public String contactMail;
     
And this tag :
  
    @text(form("contactMail"), 'label -> "Your mail : ")

The generated output will be :

    <input type="email" id="contactMail" name="contactMail" value="">

And the browser will check that the field contains an email address.

The same trick is working with `number` input type if you use max/min constraints.

## Important notes
  
### MinLength behaviour

  As `minLength` does not exist in HTML5 specification, a regular expression pattern will be used to simulate it. 
  If you need both 'minLength' and 'pattern' on a field, write the min length constraint directly in your regex pattern. Example : add `{2,}` to your pattern for minLength=2.

### Browser regex patterns

  You can check pattern compatibility with Javascript regular expressions (used by browsers) on [regexpal] (http://regexpal.com/) (check the 'Dot matches all') option.

## How to install it

In your application, add this configuration to the `project/Build.scala` file :


    val appDependencies = Seq(
      //your dependencies
      "com.loicdescotte.coffeebean" % "html5tags_2.10" % "1.0-RC1"
    )

     val main = play.Project(appName, appVersion, appDependencies).settings(
      //your settings
      resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.com/releases/"))(Resolver.ivyStylePatterns)
    )
	

## License

This project is published under the Apache License v2.0
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.