package Chapter7;

/*
Define a class named Document that contains an instance variable of type String named text that
stores any textual content for the document.
Create a method named toString that returns the text field and also include a method to set this value.
Next, define a class for Email that is derived from Document and includes instance variables for
the sender, recipient , and title of an email message.
Implement appropriate accessor and mutator methods.
The body of the email message should be stored in the inherited variable text.
Redefine the toString method to concatenate all text fields.
Similarly, define a class for File that is derived from Document and includes a instance variable for the pathname.
The textual contents of the file should be stored in the inherited variable text.
Redefine the toString method to concatenate all text fields.
Finally, create several sample objects of type Email and File in your main method.
Test your objects by passing them to the following subroutine that
returns true if the object contains the specified keyword in the text property.
*/
public class Question2
{
}

// Document.java
/*Define a class named Document that contains an instance
 * variable of type String named text that stores any
 * textual content for the document. Create a method
 * named toString that returns the text field and
 * also include a method to set this value.
 * */
class Document
{
    private String text;

    public Document(String textDoc)
    {
        setText(textDoc);
    }

    public void setText(String newTextDoc)
    {
        text = newTextDoc;
    }
    public String toString()
    {
        return text;
    }
}

//Email.java
/*Define a class for Email that is derived from Document
 * and includes instance variables for the sender, recipient,
 * and title of an email message. Implement appropriate
 * accessor and mutator methods. The body of the email
 *  message should be stored in the inherited variable
 *  textDoc. Redefine the toString method to concatenate
 *  all textDoc fields.
 * */
class Email extends Document
{
    private String sender;
    private String recipient;
    private String title;

    public Email(String textDoc, String senderMsg, String recipientMsg, String titleMsg)
    {
        super(textDoc);
        sender = senderMsg;
        recipient = recipientMsg;
        title = titleMsg;
    }

    public String getSender()
    {
        return sender;
    }

    public String getRecipient()
    {
        return recipient;
    }

    public String getTitle()
    {
        return title;
    }

    public String getText()
    {
        return super.toString();
    }

    public void setSender(String newSenderMsg)
    {
        sender = newSenderMsg;
    }

    public void setRecipient(String newRecMsg)
    {
        recipient = newRecMsg;
    }

    public void setTitle(String newTitleMsg)
    {
        title = newTitleMsg;
    }

    public String toString()
    {
        return "From: " + sender + "\nTo: " + recipient + "\n" + title + "\n\n" + super.toString();
    }
}

//main class, File.java
/*define a class for File that is derived from Document
 * and includes a instance variable for the pathname .
 * The textual contents of the file should be stored
 *  in the inherited variable text. Redefine the
 *  toString method to concatenate all text fields.
 *   Finally, create several sample objects
 *   of type Email and File in your main method.
 * */
class File extends Document
{

    private String pathname;

    public File(String textMsg, String pathDes)
    {
        super(textMsg);
        pathname = pathDes;
    }

    public String getPathname()
    {
        return pathname;
    }

    public String getText()
    {
        return super.toString();
    }

    public void setPathname(String newPath)
    {
        pathname = newPath;
    }

    public String toString()
    {
        return pathname + ": " + super.toString();
    }

    public static boolean ContainsKeyword(Document docObject, String keyword)
    {
        if (docObject.toString().indexOf(keyword, 0) >= 0)
            return true;

        return false;
    }

    public static void main(String args[])
    {
        String sample1 = "The childrens playing cricket" + " were extremely noisy.";
        String sample2 = "The lion stared at the dog " + "across the street.";
        Document email1 = new Email(sample1, "Peter", "Martin", "Childrens");
        Document email2 = new Email(sample2, "Josh", "Lucky", "animals");

        Document file1 = new File(sample1, "childrens.txt");
        Document file2 = new File(sample2, "animals.txt");
        String testWord = "Cricket";
        if (ContainsKeyword(email1, testWord))
            System.out.println("Email 1 contains the word " + testWord);
        else
            System.out.println("Email 1 does not contain " + "the word " + testWord);
        if (ContainsKeyword(email2, testWord))
            System.out.println("Email 2 contains the word " + testWord);
        else
            System.out.println("Email 2 does not contain" + " the word " + testWord);
        if (ContainsKeyword(file1, testWord))
            System.out.println("File 1 contains the word " + testWord);
        else
            System.out.println("File 1 does not contain" + " the word " + testWord);
        if (ContainsKeyword(file2, testWord))
            System.out.println("File 2 contains the word " + testWord);
        else
            System.out.println("File 2 does not contain" + " the word " + testWord);
        System.out.println("---");
        System.out.println(email1.toString());
        System.out.println("---");
        System.out.println(email2.toString());
        System.out.println("---");
        System.out.println(file1.toString());
        System.out.println(file2.toString());
    }
}
