INCLUDE Irvine32.inc

;Name: Joshua J Abraham
;Purpose: 
;Date: 26/07/2015

.stack 100h

.data
	msg_prompt db "Key in a string: ", 0
	str_len = 50	; Variable for default string length when calling ReadString
	answr BYTE ? 

.code
	main proc
		call clrscr

		mov edx, offset msg_prompt
		invoke WriteString

		mov ecx, str_len		; Giving the ecx register a default size, i.e. only strings with length str_len will be read.	
		invoke ReadString
		mov answr, edx
		
		mov esi, 0
	; Loop to push each character in string onto eax stack
	L1: 
		movzx eax, answr[esi]
		push eax
		inc esi
		loop L1
		
		mov ecx, str_len
		mov esi, 0
		
	; Loop to pop each character from eax stack back into string
	L2: 
		pop eax
		mov answr[esi], al
		inc esi
		loop L2
		 
		; display the string
		mov  edx,OFFSET answr
		call WriteString
		call Crlf					; print\r\n
		
		exit
		main endp
	end main