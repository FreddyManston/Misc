#!/bin/bash

# Premise: Find the LCM of the set of numbers from 1- 20
# Answer: 

# Simplifies set by removing multiples already in the set. E.g. removes 2 and 5 if 10 is in set, since 2 and 5 are multiples of 10
# Does it the long, by checking if each element is a multiple of another element in the list.
# Quick way is to do just remove lower half of list and keep upper half. Can be done with the following line of code:
# 	integer_list=${integer_list[@]:$((${#integer_list[@]} / 2))}
# Parameters (list of consecutive integers starting from 1)
function simplifySet {
for i in `printf '%s\n' "${integer_list[@]}"|tac`	# Loop through reverse of the array
do
	for j in ${integer_list[@]}
	do
		if [ $j -eq $i ]
		then
			break
		fi

		if [ $((i % j)) -eq 0 ]
		then
			unset integer_list[$((j-1))]
		fi
	done
done
}

integer_list=( $(seq 1 20) )	# Populate a list with integers from 1 - 20

simplifySet
echo FINAL LIST IS: ${integer_list[@]}

# Finding the lcm by running through all possiilities, starting from 2*the last element in integer_list:
is_not_lcm=true
lcm=${integer_list[-1]}

while $is_not_lcm
do
	lcm=$(( lcm + integer_list[-1] ))	# Increment lcm by the value of the last element in integer_list
	echo $lcm
	for i in ${integer_list[@]}
	do
		if [ $(( lcm % i )) -ne 0 ] 
		then
			is_not_lcm=true
			break
		fi
		is_not_lcm=false
	done
done

echo THE LOWEST COMMON MULTIPLE OF SAID SET IS: $lcm
