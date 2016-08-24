#!/bin/bash
cd hindi

export PATH=/usr/local/bin:/usr/local/libexec/sphinxtrain:$PATH
export LD_LIBRARY_PATH=/usr/local/lib
export PKG_CONFIG_PATH=/usr/local/lib/pkgconfig

sphinxtrain run
