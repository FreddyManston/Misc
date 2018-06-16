# Description: Simple PokeWalker Game. Verion 1.
# Author: F. Manston
# Date: May 2018

#!/bin/bash

poke_starter=""
echo "Pick a starter Pokemon: (B)ulbasaur | (S)quirtle | (C)harmander"
read poke_starter
until test "$poke_starter" != "B"
test "$poke_starter" != "S"
test "$poke_starter" != "C"
do
	echo "Wrong input. Try Again."
	echo "Enter: 'B' for Bulba | 'S' for Squirty | 'C' for Charry"
	read poke_starter
done
echo You chose: "$poke_starter"


