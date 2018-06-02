# Description: Simple PokeWalker Game. Verion 1.
# Author: F. Manston
# Date: May 2018

#!/bin/bash

poke_starter=""
	echo "Pick a starter Pokemon: (B)ulbasaur | (S)quirtle | (C)harmander"
	read poke_starter
while  [[  "$poke_starter" -eq 'B' || "$poke_starter" -eq 'S' || "$poke_starter" -eq 'C' ]]; do
	echo "Wrong input. Try Again."
	echo "Enter: 'B' for Bulba | 'S' for Squirty | 'C' for Charry"
	read poke_starter
done
echo "$poke_starter"


