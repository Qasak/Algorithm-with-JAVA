package main

import "fmt"

func quic_sort(a []int, p int, r int) {
	if r-p>0 {
		q := partition(a, p, r)

		quic_sort(a, p, q)
		quic_sort(a, q+1, r)
	}
}

func partition(a []int, p int, r int) int {
	x := a[r - 1]
	i := p - 1
	for j := p; j < r - 1; j++ {
		if a[j] <= x {
			i++
			a[i], a[j] = a[j], a[i]
		}
	}
	a[i+1], a[r-1] = a[r-1], a[i+1]
	return i+1
}

func main() {
	a:=[]int{643,5,6,7,9,734,5,7,9,72,4}
	quic_sort(a, 0, len(a))
	fmt.Println(a)
}