#!/bin/bash
set -ex

sudo yum clean all
wget https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
#sudo yum install epel-release-latest-7.noarch.rpm -y
#rpm --import /etc/pki/rpm-gpg/*GPG*
sudo yum localinstall   https://dl.k6.io/rpm/repo.rpm  -y 
sudo yum install   k6  -y --nogpgcheck 
