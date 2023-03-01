package main

import (
	"container/list"
	"fmt"
)

func copy0(lin *list.List) (lout *list.List) {
	lout = list.New()
	for e := lin.Front(); e != nil; e = e.Next() {
		lout.PushBack(e.Value)
	}
	return
}

func copy1(lin *list.List) (lout *list.List) {
	lout = list.New()
	for e := lin.Front(); e != nil; e = e.Next() {
		v := *(e.Value.(*uint8))
		lout.PushBack(&v)
	}
	return
}

func copy2(lin *list.List) (lout *list.List) {
	lout = lin
	return
}

func add(v uint8, l *list.List) {
	for e := l.Front(); e != nil; e = e.Next() {
		ptr := e.Value.(*uint8)
		*ptr += v
	}
}

func print_uint8ptr_list(l *list.List) {
	fmt.Print("[")
	for e := l.Front(); e != nil; e = e.Next() {
		// fmt.Printf(" (%p, %d)", e.Value, *(e.Value.(*uint8)))
		fmt.Printf(" %d", *(e.Value.(*uint8)))
	}
	fmt.Print("]\n")
}

func main() {
	ints := [10]uint8{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	l := list.New()

	for i := 0; i < 10; i++ {
		l.PushFront(&(ints[i]))
	}

	l0 := copy0(l)
	l1 := copy1(l)
	l2 := copy2(l)

	l.Remove(l.Front())

	add(10, l0)
	add(30, l1)
	add(50, l2)

	fmt.Printf("l  : ")
	print_uint8ptr_list(l)
	fmt.Printf("\nl0 : ")
	print_uint8ptr_list(l0)
	fmt.Printf("\nl1 : ")
	print_uint8ptr_list(l1)
	fmt.Printf("\nl2 : ")
	print_uint8ptr_list(l2)
}
