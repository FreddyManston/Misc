read T	# Read in the test cases

# Looping through the test cases
for i in $(seq 1 $T)
do
	read N		# Read num of people
	read line	# Read order of the line
	declare -a LINE=($line)
	declare count
	
	# Looping through the line
	for j in $(seq 1 N)
	do
		if [ ${ARRAY[$((j-1))]} -gt ${ARRAY[$((j))]} ]
		then
			#switch
		fi
	done
done
