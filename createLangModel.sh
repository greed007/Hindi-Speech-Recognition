#!/bin/bash
export LD_LIBRARY_PATH=/usr/local/lib

text2wfreq < hindi.txt | wfreq2vocab > hindi.vocab
text2idngram -vocab hindi.vocab -idngram hindi.idngram < hindi.txt
idngram2lm -vocab_type 0 -idngram hindi.idngram -vocab \
     hindi.vocab -arpa hindi.lm

cp hindi.lm hindi/etc/
