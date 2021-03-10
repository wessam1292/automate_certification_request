#!/bin/bash
###############Create the dir#####################
cd C:\\Users\\wessam\\Desktop\\newcertificates
awk -F"," '{print $1}' wessam.csv > fqdn.txt | sed -i -e "1d" fqdn.txt
fqdn_file="fqdn.txt"
year=`date "+%Y"`
month=`date "+%m"`
day=`date "+%d"`
dirname=${day}${month}${year}
mkdir -p $dirname

touch fqdn_temp.txt

sort fqdn.txt | uniq > fqdn_temp.txt
fqdn_file1="C:\Users\wessam\Desktop\\newcertificates\\fqdn_temp.txt"
cd $dirname
mkdir -p Key
cd Key

echo "csr" > C:\\Users\\wessam\\Desktop\\newcertificates\\Excelfile\\sheet1.csv
for fqdn in `cat $fqdn_file1`
do

openssl req -sha256  -nodes -newkey rsa:2048  -subj "//f=1/C=DE/ST=Ratingen/L=Ratingen/O=Vodafone Group GmbH/OU=IT/CN=${fqdn}" -keyout ${fqdn}.key -out ${fqdn}.csr 

echo "${fqdn}.csr" >>C:\\Users\\wessam\\Desktop\\newcertificates\\Excelfile\\sheet1.csv

done


#rm -f ../../fqdn_temp.txt
mkdir -p "C:\Users\wessam\Desktop\\newcertificates\CSR"
mv *.csr "C:\Users\wessam\Desktop\\newcertificates\CSR"
