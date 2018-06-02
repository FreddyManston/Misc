TITLE MASM Assignment 3 reverse a string word by word                   (assign3.asm)
; Description:
; 
; Revision date:
INCLUDE Irvine32.inc

.data
	msg    BYTE   "How do I reverse a string",0
	msgSize = ($ - msg) - 1
	
.code
	main PROC
		mov ecx, msgSize
		mov esi, 0
	; Loop to push each character in string onto eax stack
	L1: 
		movzx eax, msg[esi]
		push eax
		inc esi
		loop L1
		
		mov ecx, msgSize
		mov esi, 0
		
	; Loop to pop each character from eax stack back into string
	L2: 
		pop eax
		mov msg[esi], al
		inc esi
		loop L2
		
	; display the string
		mov  edx,OFFSET msg
		call WriteString
		call Crlf                       ; print\r\n
		
		exit
		main ENDP
	END main