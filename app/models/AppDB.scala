package models
import play.api.Play.current

/**
 * Created with IntelliJ IDEA.
 * User: gonto
 * Date: 11/23/12
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
object AppDB extends DBeable {

  lazy val database = getDb
  lazy val dal = getDal


}
