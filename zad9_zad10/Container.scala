class Container[A] {
  private var _value:A = null.asInstanceOf[A]

  def this(value:A){
    this()
    this._value = value
  }

  def getContent(): A= _value

  def applyFunction(f: A => Any): Any = f(_value)
}
