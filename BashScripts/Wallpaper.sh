#! /bin/bash
# Simple script to make a gif as a wallpaper
# Currently not working. Updating to fast to take effect or something.
# Initialise the array
i=0
nums[0]=$i
i=$[$i+1]

while true
do
  nums[$i]=$i
  if (("$i" >= "85")); then
    break
  fi
  i=$[$i+1]
done
echo ${nums[@]}

# Continuosly change the picture
while true
do
  for i in ${nums[@]}
  do
    gsettings set org.gnome.desktop.background picture-uri file:////home/juan/Pictures/ArcReactor/ArcReactorBright/ArcReactorBright-'$i'.png
  done
done
