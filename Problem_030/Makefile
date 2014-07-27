CXX=g++
CXXFILES = src/*.c*
CXXFLAGS = -O3 -o prog -Wall -std=c++11 -fno-elide-constructors -rdynamic -D_GNU_SOURCE -L./lib
INCLUDES = -I. -I./include/

all:
	    $(CXX) $(CXXFILES) $(INCLUDES) $(CXXFLAGS)

clean:
	    rm -f prog *.o
