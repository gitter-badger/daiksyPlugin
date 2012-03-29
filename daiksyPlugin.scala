package plugins

import play.api._
import scala.collection.JavaConversions
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.Status

/** 誰得プラグイン */
class daiksyPlugin(app: Application) extends Plugin {
  val name = "daiksy Plugin"
  val userName = "daiksy"
  private lazy val twitter = new TwitterFactory().getInstance

  /** とりあえず常にtrueにしとこ. */
  override lazy val enabled = true

  /** ログでも出すか. */
  override def onStart() = Logger.trace("変態が...はじまる！！")

  /** ログ出しとく. */
  override def onStop() = Logger.trace("タイ━━━━｜｜Φ｜（｜゜｜∀｜゜｜）｜Φ｜｜━━━━ホ！！")

  /** daiksyのタイムラインを取得する誰得関数 */
  def timeline = twitter.getUserTimeline(userName)

  /**
   *  daiksyの最新ツイートを取得. 本当は取得できなかったときの処理とかいるけどとりあず無視.
   *  getUserTimelineからのresponseListをscalaのコレクションとして扱って高階関数とか使いたいなー.  
   */
  def lastTweet = twitter.getUserTimeline(userName).get(0).getText
}
