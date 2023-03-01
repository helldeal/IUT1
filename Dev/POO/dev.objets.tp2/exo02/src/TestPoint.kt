
fun main() {
	var p1 = Point(0,0)
	var p2 = Point(1,2)
	println(p1)
	println(p2)
	p2.deplacer(1,3)
	println(p2)
	p2.deplacer(p2.x+1,p2.y+1)
	println(p2)
	p1.deplacer(2,10)
	println(p1)
	println(p2.distance(Point(0,0)))
	println(p2.distance(p1))
	p1=p2
	p1.deplacer(2,1)
	println(p1)
	println(p2)

}
