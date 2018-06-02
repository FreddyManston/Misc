title Hello World programme
; 				(This is how you make comments.)
;Name: Joshua Abraham
;Purpose: Programme displays 'Hello World'
;Date: 15/07/2015
include irvine32.inc		; from Irvine CDROM
.stack 100h
.data
HelloString db "Hello, world", 0	; message to display
.code
main proc
mov edx, offset HelloString
invoke WriteString		; irvine.inc: write NUL terminated string pointed to by edx
exit			; irvine.inc a macro that calls ExitProcess
main endp
end main
