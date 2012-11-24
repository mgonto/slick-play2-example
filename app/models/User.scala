package models



/**
 * Created with IntelliJ IDEA.
 * User: gonto
 * Date: 11/23/12
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
case class User(id: Option[Int], name : String)

trait UserComponent {
  this: Profile =>

  import profile.simple._

  object Users extends Table[User]("users") {
    def id = column[Int]("id", O.PrimaryKey)
    def name =  column[String]("name", O.NotNull)
    def * = id.? ~ name <> (User, User.unapply _)

    def add(user: User)(implicit session: Session) = {
      this.insert(user)
    }

    def countByName(name: String)(implicit session: Session) = {
      (for {
        user <- Users
        if (user.name === name)
      } yield(user)).list.size
    }

  }
}