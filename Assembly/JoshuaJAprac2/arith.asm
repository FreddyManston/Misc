INCLUDE Irvine32.inc
;
;Name: Joshua Abraham
;Purpose: 
;Date: <22 July 2015>
;include irvine32.inc	;from irvine CDROM
.stack 100h

.data
	int_prompt db "Type in an integer: ", 0
	val1 dd ?      ; defines a variable where to store the user's response
	val2 dd ?  

.code
main PROC	
	call clrscr	; Call the command to clear the terminal screen
		
	mov edx, offset int_prompt	; Move prompt1 string into edx register	
	invoke WriteString	; Prompt the user	
	invoke ReadInt	; Asks user for int input and moves input into eax register

	mov val1, eax
	invoke WriteString
	invoke ReadInt
	mov val2, eax
	
	; Addition
	add eax, val1	; Adds val1 to the int in the eax register (which would be the last input the user gave, in this case)
	invoke WriteInt
	invoke crlf	; Invokes newline method in terminal
	
	; Subtraction
	sub eax, val2
	sub eax, val2
	invoke WriteInt
	invoke crlf
	
	; Multiplication
	add eax, val2
	imul val2	; Multiplies the value in the eax register with the value in val2
	invoke WriteInt
	invoke crlf
	; Division
	mov eax, val1	; Replaces the current value in eax with the value in val1
	idiv val2	; Divides the value in the eax register with the value in val2
	invoke WriteInt
	invoke crlf
	
   exit
main ENDP
END main




