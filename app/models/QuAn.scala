package models

/**
 * An entry in the question/answer catalogue.
 *
 * @param qid - a unique identifier
 * @param category - Movies, Sports, Geographies, Musics, Histories, etc
 * @param question - the question
 * @param correctAns - correct answer
 * @param ans1 - ans1
 * @param ans2 - ans2
 * @param ans3 - ans3
 */
case class QuAn(qid: Long, category: String, question: String, correctAns: String, ans1: String, ans2: String, ans3: String)

object QuAn {

  var questions = Set(
    QuAn(1L, "Geographies", "Where is USA?", "North America", "Europe", "South Africa", "Asia")
  )

  /**
   * Questions sorted by qid.
   */
  def findAll = this.questions.toList.sortBy(_.qid)

  /**
   * The questions with the given qid.
   */
  def findById(qid: Long) = this.questions.find(_.qid == qid)

  /**
   * Save a questions to the catalog.
   */
  def save(question: QuAn) = {
    findById(question.qid).map( oldQuestion =>
      this.questions = this.questions - oldQuestion + question
    ).getOrElse(
      this.questions = this.questions + question
      //throw new IllegalArgumentException("Question not found")
    )
  }

   
}
