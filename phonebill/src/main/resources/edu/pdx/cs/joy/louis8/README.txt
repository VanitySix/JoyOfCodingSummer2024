# Phone Bill Application

This Java application models a phone bill for a customer and tracks the customers phone calls with various details.
It allows users to add phone calls to a phone bill, print details of a specific phone call, and dump the phone bill to a text file.

## Content
- [How To Use The Program](#how-to-use-the-program)
- [Command Line Examples](#command-line-examples)
- [Command Line Options](#command-line-options)

## How To Use The Program
The user interface provides details that should be sufficient for you to know how to run it. Use the command
java -jar target/phonebill-1.0.0.jar [options] <args>. Arguments must be in the following order customer,callerNumber, calleeNumber.
begin (start date and time), and end (end date and time). Customer name MUST be in quotations if first and last name is included. Phone number MUST be in the format nnn-nnn-nnnn,
where n is 0-9. The month and hour of begin and end can be single digit. Options can be in Before or after arguments.

## Command Line Examples

- -print -textFile phonebill/phoneBill.txt "John Doe" 123-456-7890 111-111-1111 08/01/2024 10:00 08/01/2024 11:00
- Program will print out newly created phone call and write to the phoneBill.txt file in the directory phonebill.
- "John Doe" 123-456-7890 111-111-1111 08/01/2024 10:00 08/01/2024 11:00
- If -textfile option is not chosen or provided, default.txt will be created in the current directory.

## Command Line Options

* print - reads out the description of the newly added phone call.
* textFile - followed by the directory name, a new directory/file will be created. The default directory is default.txt if none is specified.
* README - print out the README file.