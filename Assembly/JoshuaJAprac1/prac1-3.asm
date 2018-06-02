title Hello World programme
; 				(This is how you make comments.)
;Name: Joshua Abraham
;Purpose: Programme displays a string, 'CSC21...', and another on a new line, 'Prac1...'
;Date: 15/07/2015
include irvine32.inc		; from Irvine CDROM
.stack 100h

.data
	my_string db "CSC212 is FUN",10,13, "Prac1 <Joshua Abraham>", 0	; 10,13, tells the computer to print a newline character, similar to \n in Java
.code
	main proc
		mov edx, offset my_string
		invoke WriteString		; irvine.inc: write NUL terminated string pointed to by ax	
		exit					; irvine.inc a macro that calls ExitProcess
		main endp
	end main
	
	
	
