package models

/**
 * Quiz request from a user
 *
 * @param userId  - a unique userId
 * @param category - category
 * @param num  - how many
 */
case class QuizRequest(userId: Long, category: String, num: Int)


