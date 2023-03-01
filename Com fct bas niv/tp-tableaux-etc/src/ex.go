package main

import (
	"fmt"
)

//go:noinline
func print(t []int32) {
	fmt.Print("{")
	for i := 0; i < len(t)-1; i++ {
		fmt.Print(t[i], ", ")
	}
	fmt.Printf("%d}\n", t[len(t)-1])
}

//go:noinline
func swap(v1 *int32, v2 *int32) (r int32) {
	tmp := *v1
	*v1 = *v2
	*v2 = tmp
	r = *v1 + *v2
	return
}

func main() {
	var w = [8]int32{2, 3, 5, 7, 11, 13, 17, 19}

	x := w

	y := w[:]

	z := &x
+
	for cpt := 0; cpt < len(y); cpt++ {
		_ = swap(&((*z)[cpt]), &(y[(cpt+2)%len(y)]))
	}

	print(w[:])
	print(x[:])
	print(y)
	print((*z)[:])

}
