package main

import (
	"math/rand"
	"testing"
)

func BenchmarkAdditionBasique(b *testing.B) {
	for i := 0; i < b.N; i++ {
		a, b := rand.Intn(1000), rand.Intn(1000)
		additionBasique(a, b)
	}
}

func BenchmarkAdditionVersPointeur(b *testing.B) {
	for i := 0; i < b.N; i++ {
		a, b := rand.Intn(1000), rand.Intn(1000)
		additionVersPointeur(a, b)
	}
}

func BenchmarkAdditionDepuisPointeurs(b *testing.B) {
	for i := 0; i < b.N; i++ {
		a, b := rand.Intn(1000), rand.Intn(1000)
		additionDepuisPointeurs(&a, &b)
	}
}
