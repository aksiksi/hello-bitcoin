#!/usr/bin/env bash

# Download and extract Bitcoin
yum install -y wget
wget https://bitcoin.org/bin/bitcoin-core-0.12.1/bitcoin-0.12.1-linux64.tar.gz
tar xzf bitcoin-0.12.1-linux64.tar.gz

# Install binaries to /usr/local/bin
sudo install -m 0755 -o root -g root -t /usr/local/bin bitcoin-0.12.1/bin/*

# Setup Bitcoin config dir
mkdir ~/.bitcoin
touch ~/.bitcoin/bitcoin.conf
chmod 600 ~/.bitcoin/bitcoin.conf
echo "rpcuser=test" >> ~/.bitcoin/bitcoin.conf
echo "rpcpassword=test" >> ~/.bitcoin/bitcoin.conf
