case class Osoba2(private var _imie: String, private var _nazwisko: String) {
  def ime = _imie
  def nazwisko = _nazwisko
  def podatek = _podatek
  private var _podatek = 0.0

  def this(imie: String) {
    this(imie, "")
  }

  def this(imie: String, nazwisko: String, podatek: Double){
    this(imie, nazwisko)
    this._podatek = podatek
  }
}


trait Student extends Osoba2{
  override def podatek = {
    0.0
  }
}


trait Nauczyciel extends Pracownik {
  override def podatek = {
    0.1 * pensja
  }
}


trait Pracownik extends Osoba2 {
  var pensja = 0

  override def podatek = {
    0.2 * pensja
  }
}










