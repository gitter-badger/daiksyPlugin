package plugins

import play.api._
import twitter4j.Twitter
import twitter4j.TwitterFactory

/** 誰得プラグイン */
class daiksyPlugin(app: Application) extends Plugin {
  val name = "daiksy Plugin"
  private lazy val twitter = new TwitterFactory().getInstance
    
  /** とりあえず常にtrueにしとこ. */
  override lazy val enabled = true

  /** ログでも出すか. */
  override def onStart() = Logger.trace("変態が...はじまる！！")

  /** ログ出しとく. */
  override def onStop() = Logger.trace("タイ━━━━｜｜Φ｜（｜゜｜∀｜゜｜）｜Φ｜｜━━━━ホ！！")
  
  /** daiksyのタイムラインを取得する誰得関数 */
  def timeline = twitter.getUserTimeline("daiksy")
}