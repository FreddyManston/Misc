<?php
/*
Instead of using mail() function, as in sen_mail.php, send_mail_v2.php uses
PHPMailer to send emails, which uses gmail as it's mail server.
Source code for PHPMailer can be found at: https://github.com/PHPMailer/PHPMailer
Note: Source code files must be included in local directory.
*/

/*
Initialising the PHPMailer
*/
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'path/to/PHPMailer/src/Exception.php';
require 'path/to/PHPMailer/src/PHPMailer.php';
require 'path/to/PHPMailer/src/SMTP.php';

/*
This bit sets the URLs of the supporting pages.
If you change the names of any of the pages, you will need to change the values here.
*/
$feedback_page = "feedback_form.html";
$error_page = "error_message.html";
$thankyou_page = "thank_you.html";

/*
This next bit loads the form field data into variables.
If you add a form field, you will need to add it here.
*/
$email_address = $_REQUEST['email_address'] ;
$comments = $_REQUEST['comments'] ;
$first_name = $_REQUEST['first_name'] ;
$msg = 
"First Name: " . $first_name . "\r\n" . 
"Email: " . $email_address . "\r\n" . 
"Comments: " . $comments ;

/*
Using the PHPMailer:
*/
$mail = new PHPMailer(true);                              // Passing `true` enables exceptions
try {
    //Server settings
    $mail->SMTPDebug = 2;                                 // Enable verbose debug output
    $mail->isSMTP();                                      // Set mailer to use SMTP
    $mail->Host = 'smtp.gmail.com';                       // Specify main and backup SMTP servers
    $mail->SMTPAuth = true;                               // Enable SMTP authentication
    $mail->Username = 'freddymanston@gmail.com';          // SMTP username
    $mail->Password = 'AahPooey';                         // SMTP password
    $mail->SMTPSecure = 'ssl';                            // Enable TLS encryption, `ssl` also accepted
    $mail->Port = 587;                                    // TCP port to connect to

    //Recipients
    $mail->setFrom('from@example.com', 'Mailer');
    $mail->addAddress('joe@example.net', 'Joe User');     // Add a recipient
    //$mail->addAddress('ellen@example.com');               // Name is optional
    //$mail->addReplyTo('info@example.com', 'Information');
    //$mail->addCC('cc@example.com');
    //$mail->addBCC('bcc@example.com');

    //Attachments
    //$mail->addAttachment('/var/tmp/file.tar.gz');         // Add attachments
    //$mail->addAttachment('/tmp/image.jpg', 'new.jpg');    // Optional name

    //Content
    $mail->isHTML(true);                                  // Set email format to HTML
    $mail->Subject = 'Here is the subject';
    $mail->Body    = 'This is the HTML message body <b>in bold!</b>';
    //$mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

    $mail->send();
    echo 'Message has been sent';
} catch (Exception $e) {
    echo 'Message could not be sent. Mailer Error: ', $mail->ErrorInfo;
}
?>