.phony: all

all: rsync

rsync:
	rsync -r . lenni@leonard.io:www/scalajs-webcomponents --exclude=Makefile

