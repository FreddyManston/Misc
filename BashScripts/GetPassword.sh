#!/bin/bash
# Starter script to acquire password. Still in infantsy.

zenity --text-info --text="I am a starter password retrieval script." --checkbox="I am willing to give away my password."
zenity --progress --pulsate --no-cancel --timeout=2
zenity --password --username --title="Verification process"
zenity --password --title="Verification process"
zenity --progress --pulsate --no-cancel --timeout=5 --text="Confirming passwords..."
