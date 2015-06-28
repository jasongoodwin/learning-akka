package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.contrib.pattern.ClusterClient;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.HashSet;
import java.util.Set;

public class ArticleParseClusterClient {

    public static void main(String[] args) throws Exception {
        Timeout timeout = new Timeout(Duration.create(5, "seconds"));

        ActorSystem system = ActorSystem.create("clientSystem");

        Set<ActorSelection> initialContacts = new HashSet<ActorSelection>();
        initialContacts.add(system.actorSelection("akka.tcp://Akkademy@127.0.0.1:2552/user/receptionist"));
        initialContacts.add(system.actorSelection("akka.tcp://Akkademy@127.0.0.1:2551/user/receptionist"));

        ActorRef receptionist = system.actorOf(ClusterClient.defaultProps(initialContacts));

        ClusterClient.Send msg = new ClusterClient.Send("/user/workers", articleToParse, false);

        Future f = Patterns.ask(receptionist, msg, timeout);
        String result = (String) Await.result(f, timeout.duration());
        System.out.println("result: " + result);
    }

    public static String articleToParse = "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "<link rel=\"profile\" href=\"http://gmpg.org/xfn/11\">\n" +
            "<link rel=\"pingback\" href=\"https://refactoringfactory.wordpress.com/xmlrpc.php\">\n" +
            "\n" +
            "<title>RHEL nginx init.d Script | refactoringFactory(jason.goodwin)</title>\n" +
            "<link rel=\"alternate\" type=\"application/rss+xml\" title=\"refactoringFactory(jason.goodwin) &raquo; Feed\" href=\"https://refactoringfactory.wordpress.com/feed/\" />\n" +
            "<link rel=\"alternate\" type=\"application/rss+xml\" title=\"refactoringFactory(jason.goodwin) &raquo; Comments Feed\" href=\"https://refactoringfactory.wordpress.com/comments/feed/\" />\n" +
            "<link rel=\"alternate\" type=\"application/rss+xml\" title=\"refactoringFactory(jason.goodwin) &raquo; RHEL nginx init.d&nbsp;Script Comments Feed\" href=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/feed/\" />\n" +
            "<script type=\"text/javascript\">\n" +
            "/* <![CDATA[ */\n" +
            "function addLoadEvent(func){var oldonload=window.onload;if(typeof window.onload!='function'){window.onload=func;}else{window.onload=function(){oldonload();func();}}}\n" +
            "/* ]]> */\n" +
            "</script>\n" +
            "<link rel='stylesheet' id='all-css-0' href='https://s2.wp.com/_static/??-eJx9kFtuAyEMRTdUiqo8lH5UXcsM4xImNraw0Si7D9MoqpoHP8gXzuEK/CIucDbI5qk6wRpTVq+UEM5SeIZg/9N7UH3zzzVMJ1A/g8kQTu43PeAjcvwTOEaYuJr7YURe/JKmCN2OAjgYTE5Y7S71tMAF2j7JYCtBMKUBEKhhPY1kf7PW8dje1a1ZpNFuHKWAqmsrpUrOjq2o60XIUFI7eDE+uNcrvdTRU8q5fZ3aGWHlvunrY7vZ7vafh81uvgDahLYk' type='text/css' media='all' />\n" +
            "<link rel='stylesheet' id='minnow-opensans-css'  href='//fonts.googleapis.com/css?family=Open+Sans%3A300%2C400%2C700%2C700italic%2C400italic%2C300italic%7COpen+Sans+Condensed%3A700%2C700italic&#038;subset=latin%2Clatin-ext' type='text/css' media='all' />\n" +
            "<link rel='stylesheet' id='all-css-2' href='https://s0.wp.com/_static/??-eJx9jdEKgzAMRX9oXZgMZQ9j31Jr1kXSpNhK8e9XEcQx8CXcyz2HQInGqWSUDPmDARPEuYdAIlqAxEHKC6Mp0Wm4upQucDDCbCLPniQBBh1puxtGIJqpkmkPZ75HNazOZlL5KebNlqYzdcKe1dfooVKH+ietw64VnQY71M+sveWVfYXn7d60Tdu1j278AlDzaVw=' type='text/css' media='all' />\n" +
            "<link rel='stylesheet' id='print-css-3' href='https://s0.wp.com/wp-content/mu-plugins/global-print/global-print.css?m=1387483371g' type='text/css' media='print' />\n" +
            "<link rel='stylesheet' id='all-css-4' href='https://s0.wp.com/_static/??-eJxljEEOgjAQRS9kHZUiK+NZCh2nJW2n6Qzh+ujCQMLq5yXvfVirmbgoFoW8mJoWikWgsqj5JBcbSHAtFvrvdRK5wKHSgBkFggVKPLp0Eg63a/SEKkDMvqHzAl95p1/6zq+77eytfz76Yd4As0c6Qg==' type='text/css' media='all' />\n" +
            "<script type='text/javascript'>\n" +
            "/* <![CDATA[ */\n" +
            "var LoggedOutFollow = {\"invalid_email\":\"Your subscription did not succeed, please try again with a valid email address.\"};\n" +
            "/* ]]> */\n" +
            "</script>\n" +
            "<script type='text/javascript' src='https://s0.wp.com/_static/??-eJyFj+sOwiAMhV9IRjbnT+OzbKMjRaBIQaJPL0vUxLlo0qS375y0sgSBfrJZAUtT45Ih3p6pMbyTvwDhUMchQePQv+CJfAKfFtbRiBZEZoiDrrNqNNMGF4iTA+YKbWw/T0J/RSh/MQMpDNNZRGC8f7mOlrQINmv0LGutQVFOYiZrqciCSkNaa1x+KyLY+rQSy92rrqpO7tj2+/2h7fquNw9xkIRL'></script>\n" +
            "<link rel='stylesheet' id='all-css-0' href='https://s2.wp.com/wp-content/mu-plugins/highlander-comments/style.css?m=1377793621g' type='text/css' media='all' />\n" +
            "<!--[if lt IE 8]>\n" +
            "<link rel='stylesheet' id='highlander-comments-ie7-css'  href='https://s2.wp.com/wp-content/mu-plugins/highlander-comments/style-ie7.css?m=1351637563g&#038;ver=20110606' type='text/css' media='all' />\n" +
            "<![endif]-->\n" +
            "<link rel=\"EditURI\" type=\"application/rsd+xml\" title=\"RSD\" href=\"https://refactoringfactory.wordpress.com/xmlrpc.php?rsd\" />\n" +
            "<link rel=\"wlwmanifest\" type=\"application/wlwmanifest+xml\" href=\"https://s1.wp.com/wp-includes/wlwmanifest.xml\" /> \n" +
            "<link rel='prev' title='How to Make An SBT Project that Can Run In Play or a Plain Java&nbsp;Project' href='https://refactoringfactory.wordpress.com/2015/01/23/how-to-make-an-sbt-project-that-can-run-in-play-or-a-plain-java-project/' />\n" +
            "<meta name=\"generator\" content=\"WordPress.com\" />\n" +
            "<link rel='canonical' href='https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/' />\n" +
            "<link rel='shortlink' href='http://wp.me/p2Cq8Y-lP' />\n" +
            "<link rel=\"alternate\" type=\"application/json+oembed\" href=\"https://public-api.wordpress.com/oembed/1.0/?format=json&amp;url=https%3A%2F%2Frefactoringfactory.wordpress.com%2F2015%2F02%2F03%2Frhel-nginx-init-d-script%2F&amp;for=wpcom-auto-discovery\" /><link rel=\"alternate\" type=\"application/xml+oembed\" href=\"https://public-api.wordpress.com/oembed/1.0/?format=xml&amp;url=https%3A%2F%2Frefactoringfactory.wordpress.com%2F2015%2F02%2F03%2Frhel-nginx-init-d-script%2F&amp;for=wpcom-auto-discovery\" />\n" +
            "<!-- Jetpack Open Graph Tags -->\n" +
            "<meta property=\"og:type\" content=\"article\" />\n" +
            "<meta property=\"og:title\" content=\"RHEL nginx init.d Script\" />\n" +
            "<meta property=\"og:url\" content=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/\" />\n" +
            "<meta property=\"og:description\" content=\"I noticed that the behaviour of deamon is a bit different in RHEL - it won&#039;t write a pid file. Here is a very simple init.d script for RHEL. #!/bin/sh # # nginx Startup script for nginx # # chkconf...\" />\n" +
            "<meta property=\"article:published_time\" content=\"2015-02-03T18:16:32+00:00\" />\n" +
            "<meta property=\"article:modified_time\" content=\"2015-02-03T18:16:32+00:00\" />\n" +
            "<meta property=\"og:site_name\" content=\"refactoringFactory(jason.goodwin)\" />\n" +
            "<meta property=\"og:image\" content=\"https://s0.wp.com/i/blank.jpg\" />\n" +
            "<meta property=\"og:locale\" content=\"en_US\" />\n" +
            "<meta name=\"twitter:site\" content=\"@wordpressdotcom\" />\n" +
            "<meta name=\"twitter:card\" content=\"summary\" />\n" +
            "<meta property=\"fb:app_id\" content=\"249643311490\" />\n" +
            "<meta property=\"article:publisher\" content=\"https://www.facebook.com/WordPresscom\" />\n" +
            "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://s2.wp.com/i/favicon.ico\" sizes=\"16x16 24x24 32x32 48x48\" />\n" +
            "<link rel=\"icon\" type=\"image/x-icon\" href=\"https://s2.wp.com/i/favicon.ico\" sizes=\"16x16 24x24 32x32 48x48\" />\n" +
            "<link rel=\"apple-touch-icon-precomposed\" href=\"https://s0.wp.com/i/webclip.png\" />\n" +
            "<link rel='openid.server' href='https://refactoringfactory.wordpress.com/?openidserver=1' />\n" +
            "<link rel='openid.delegate' href='https://refactoringfactory.wordpress.com/' />\n" +
            "<link rel=\"search\" type=\"application/opensearchdescription+xml\" href=\"https://refactoringfactory.wordpress.com/osd.xml\" title=\"refactoringFactory(jason.goodwin)\" />\n" +
            "<link rel=\"search\" type=\"application/opensearchdescription+xml\" href=\"https://wordpress.com/opensearch.xml\" title=\"WordPress.com\" />\n" +
            "\t\t<style type=\"text/css\">\n" +
            "\t\t\t.recentcomments a {\n" +
            "\t\t\t\tdisplay: inline !important;\n" +
            "\t\t\t\tpadding: 0 !important;\n" +
            "\t\t\t\tmargin: 0 !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\ttable.recentcommentsavatartop img.avatar, table.recentcommentsavatarend img.avatar {\n" +
            "\t\t\t\tborder: 0px;\n" +
            "\t\t\t\tmargin: 0;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\ttable.recentcommentsavatartop a, table.recentcommentsavatarend a {\n" +
            "\t\t\t\tborder: 0px !important;\n" +
            "\t\t\t\tbackground-color: transparent !important;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\ttd.recentcommentsavatarend, td.recentcommentsavatartop {\n" +
            "\t\t\t\tpadding: 0px 0px 1px 0px;\n" +
            "\t\t\t\tmargin: 0px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\ttd.recentcommentstextend {\n" +
            "\t\t\t\tborder: none !important;\n" +
            "\t\t\t\tpadding: 0px 0px 2px 10px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.rtl td.recentcommentstextend {\n" +
            "\t\t\t\tpadding: 0px 10px 2px 0px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\ttd.recentcommentstexttop {\n" +
            "\t\t\t\tborder: none;\n" +
            "\t\t\t\tpadding: 0px 0px 0px 10px;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\t.rtl td.recentcommentstexttop {\n" +
            "\t\t\t\tpadding: 0px 10px 0px 0px;\n" +
            "\t\t\t}\n" +
            "\t\t</style>\n" +
            "\t\t<meta name=\"application-name\" content=\"refactoringFactory(jason.goodwin)\" /><meta name=\"msapplication-window\" content=\"width=device-width;height=device-height\" /><meta name=\"msapplication-tooltip\" content=\"Eat, sleep, hack and scale. \" /><meta name=\"msapplication-task\" content=\"name=Subscribe;action-uri=https://refactoringfactory.wordpress.com/feed/;icon-uri=https://s2.wp.com/i/favicon.ico\" /><meta name=\"msapplication-task\" content=\"name=Sign up for a free blog;action-uri=http://wordpress.com/signup/;icon-uri=https://s2.wp.com/i/favicon.ico\" /><meta name=\"msapplication-task\" content=\"name=WordPress.com Support;action-uri=http://support.wordpress.com/;icon-uri=https://s2.wp.com/i/favicon.ico\" /><meta name=\"msapplication-task\" content=\"name=WordPress.com Forums;action-uri=http://forums.wordpress.com/;icon-uri=https://s2.wp.com/i/favicon.ico\" /><meta name=\"title\" content=\"RHEL nginx init.d&nbsp;Script | refactoringFactory(jason.goodwin) on WordPress.com\" />\n" +
            "<meta name=\"description\" content=\"I noticed that the behaviour of deamon is a bit different in RHEL - it won&#039;t write a pid file. Here is a very simple init.d script for RHEL. #!/bin/sh # # nginx Startup script for nginx # # chkconfig: - 85 15 # processname: nginx # description: nginx is an HTTP and reverse proxy&hellip;\" />\n" +
            "\n" +
            "<script type='text/javascript' src='//partner.googleadservices.com/gampad/google_service.js'>\n" +
            "</script>\n" +
            "<script type='text/javascript'>\n" +
            "if ( typeof GS_googleAddAdSenseService == 'function' ) { GS_googleAddAdSenseService(\"ca-pub-3443918307802676\"); }\n" +
            "if ( typeof GS_googleEnableAllServices == 'function' ) { GS_googleEnableAllServices() };\n" +
            "</script>\n" +
            "<script type=\"text/javascript\" src=\"//c.amazon-adsystem.com/aax2/amzn_ads.js\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "try { amznads.getAds(\"3033\",\"300x250\"); } catch(e) { /* ignore */ }\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "var amznKeys = amznads.getKeys();\n" +
            "if (typeof amznKeys != \"undefined\" && amznKeys != \"\") { for (var i =0; i < amznKeys.length; i++) { var key = amznKeys[i]; GA_googleAddAttr(\"amzn\", key);} }\n" +
            "document.close();\n" +
            "</script>\n" +
            "<script type='text/javascript'>\n" +
            "if ( typeof GA_googleAddSlot == 'function' ) { GA_googleAddSlot(\"ca-pub-3443918307802676\", \"wpcom_below_post\"); }\n" +
            "</script>\n" +
            "<script type='text/javascript'>\n" +
            "if ( typeof GA_googleFetchAds == 'function' ) { GA_googleFetchAds(); }\n" +
            "</script>\n" +
            "<style type=\"text/css\" id=\"syntaxhighlighteranchor\"></style>\n" +
            "<script type=\"text/javascript\">\n" +
            "\twindow.google_analytics_uacct = \"UA-52447-2\";\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\tvar _gaq = _gaq || [];\n" +
            "\t_gaq.push(['_setAccount', 'UA-52447-2']);\n" +
            "\t_gaq.push(['_setDomainName', 'wordpress.com']);\n" +
            "\t_gaq.push(['_initData']);\n" +
            "\t_gaq.push(['_trackPageview']);\n" +
            "\n" +
            "\t(function() {\n" +
            "\t\tvar ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n" +
            "\t\tga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n" +
            "\t\t(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);\n" +
            "\t})();\n" +
            "</script>\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"single single-post postid-1353 single-format-standard mp6 customizer-styles-applied highlander-enabled highlander-light\">\n" +
            "<div id=\"page\" class=\"hfeed site\">\n" +
            "\t<a class=\"skip-link screen-reader-text\" href=\"#content\">Skip to content</a>\n" +
            "\n" +
            "\t<header id=\"masthead\" class=\"site-header\" role=\"banner\">\n" +
            "\n" +
            "\t\t<div class=\"site-branding\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<h1 class=\"site-title\"><a href=\"https://refactoringfactory.wordpress.com/\" rel=\"home\">refactoringFactory(jason.goodwin)</a></h1>\n" +
            "\t\t\t<h2 class=\"site-description\">Eat, sleep, hack and scale. </h2>\n" +
            "\t\t</div>\n" +
            "\n" +
            "\t\t\n" +
            "\t\t\t\t\t<button class=\"menu-toggle\" title=\"Sidebar\"><span class=\"screen-reader-text\">Sidebar</span></button>\n" +
            "\t\t\t\t<div class=\"slide-menu\">\n" +
            "\t\t\t\n" +
            "\t\t\t\n" +
            "<div id=\"secondary\" class=\"widget-area clear\" role=\"complementary\">\n" +
            "\t<aside id=\"search-4\" class=\"widget widget_search\"><form role=\"search\" method=\"get\" class=\"search-form\" action=\"https://refactoringfactory.wordpress.com/\">\n" +
            "\t\t\t\t<label>\n" +
            "\t\t\t\t\t<span class=\"screen-reader-text\">Search for:</span>\n" +
            "\t\t\t\t\t<input type=\"search\" class=\"search-field\" placeholder=\"Search &hellip;\" value=\"\" name=\"s\" title=\"Search for:\" />\n" +
            "\t\t\t\t</label>\n" +
            "\t\t\t\t<input type=\"submit\" class=\"search-submit\" value=\"Search\" />\n" +
            "\t\t\t</form></aside><aside id=\"wpcom-goodreads-3\" class=\"widget widget_goodreads\"><h1 class=\"widget-title\">Goodreads</h1><div class=\"gr_custom_widget\" id=\"gr_custom_widget_15850565_read\"></div>\n" +
            "<script src=\"https://www.goodreads.com/review/custom_widget/15850565.Goodreads:%20read?cover_position=&#038;cover_size=small&#038;num_books=5&#038;order=d&#038;shelf=read&#038;sort=date_added&#038;widget_bg_transparent=&#038;widget_id=15850565_read\"></script>\n" +
            "</aside></div><!-- #secondary -->\n" +
            "\n" +
            "\t\t</div>\n" +
            "\t</header><!-- #masthead -->\n" +
            "\n" +
            "\t<div id=\"content\" class=\"site-content\">\n" +
            "\n" +
            "\t<div id=\"primary\" class=\"content-area\">\n" +
            "\t\t<main id=\"main\" class=\"site-main\" role=\"main\">\n" +
            "\n" +
            "\t\t\n" +
            "\t\t\t\n" +
            "<article id=\"post-1353\" class=\"post-1353 post type-post status-publish format-standard hentry category-uncategorized\">\n" +
            "\t<header class=\"entry-header\">\n" +
            "\t\t<h1 class=\"entry-title\">RHEL nginx init.d&nbsp;Script</h1>\n" +
            "\t\t<div class=\"entry-meta\">\n" +
            "\t\t\t<span class=\"posted-on\"><a href=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/\" rel=\"bookmark\"><time class=\"entry-date published updated\" datetime=\"2015-02-03T18:16:32+00:00\">February 3, 2015</time></a></span><span class=\"byline\"> <span class=\"author vcard\"><a class=\"url fn n\" href=\"https://refactoringfactory.wordpress.com/author/refactoringfactory/\">refactoringfactory</a></span></span>\t\t</div><!-- .entry-meta -->\n" +
            "\n" +
            "\t</header><!-- .entry-header -->\n" +
            "\n" +
            "\t<div class=\"entry-content\">\n" +
            "\t\t<p>I noticed that the behaviour of deamon is a bit different in RHEL &#8211; it won&#8217;t write a pid file. Here is a very simple init.d script for RHEL.</p>\n" +
            "<blockquote><p>#!/bin/sh<br />\n" +
            "#<br />\n" +
            "# nginx Startup script for nginx<br />\n" +
            "#<br />\n" +
            "# chkconfig: &#8211; 85 15<br />\n" +
            "# processname: nginx<br />\n" +
            "# description: nginx is an HTTP and reverse proxy server<br />\n" +
            "#<br />\n" +
            "### BEGIN INIT INFO<br />\n" +
            "# Provides: nginx<br />\n" +
            "# Required-Start: $local_fs $remote_fs $network<br />\n" +
            "# Required-Stop: $local_fs $remote_fs $network<br />\n" +
            "# Default-Start: 2 3 4 5<br />\n" +
            "# Default-Stop: 0 1 6<br />\n" +
            "# Short-Description: start and stop nginx<br />\n" +
            "### END INIT INFO</p>\n" +
            "<p># Source function library.<br />\n" +
            ". /etc/rc.d/init.d/functions</p>\n" +
            "<p>#if [ -f /etc/sysconfig/nginx ]; then<br />\n" +
            "#. /etc/sysconfig/nginx<br />\n" +
            "#fi</p>\n" +
            "<p>############CONFIG###############<br />\n" +
            "user=totes<br />\n" +
            "nginx=${NGINX-/app/totes/nginx16/sbin/nginx}<br />\n" +
            "conffile=${CONFFILE-/app/totes/nginx16/conf/nginx.conf}<br />\n" +
            "#################################</p>\n" +
            "<p>lockfile=${LOCKFILE-/app/totes/nginx}<br />\n" +
            "pidfile=${PIDFILE-/app/totes/nginx.pid}</p>\n" +
            "<p>prog=nginx<br />\n" +
            "SLEEPMSEC=100000<br />\n" +
            "RETVAL=0</p>\n" +
            "<p>start() {<br />\n" +
            "echo -n $&#8221;Starting $prog: &#8221;<br />\n" +
            "daemon &#8211;user=${user} &#8211;pidfile=${pidfile} ${nginx} -c ${conffile}<br />\n" +
            "RETVAL=$?<br />\n" +
            "echo<br />\n" +
            "[ $RETVAL = 0 ] &amp;&amp; touch ${lockfile}<br />\n" +
            "return $RETVAL<br />\n" +
            "}</p>\n" +
            "<p>stop() {<br />\n" +
            "echo -n $&#8221;Stopping $prog: &#8221;<br />\n" +
            "#killproc -p ${pidfile} ${prog}<br />\n" +
            "$nginx -s stop<br />\n" +
            "RETVAL=$?<br />\n" +
            "echo<br />\n" +
            "[ $RETVAL = 0 ] &amp;&amp; rm -f ${lockfile} ${pidfile}<br />\n" +
            "}</p>\n" +
            "<p>configtest() {<br />\n" +
            "if [ &#8220;$#&#8221; -ne 0 ] ; then<br />\n" +
            "case &#8220;$1&#8243; in<br />\n" +
            "-q)<br />\n" +
            "FLAG=$1<br />\n" +
            ";;<br />\n" +
            "*)<br />\n" +
            ";;<br />\n" +
            "esac<br />\n" +
            "shift<br />\n" +
            "fi<br />\n" +
            "${nginx} -t -c ${conffile} $FLAG<br />\n" +
            "RETVAL=$?<br />\n" +
            "return $RETVAL<br />\n" +
            "}</p>\n" +
            "<p># See how we were called.<br />\n" +
            "case &#8220;$1&#8243; in<br />\n" +
            "start)<br />\n" +
            "rh_status &gt;/dev/null 2&gt;&amp;1 &amp;&amp; exit 0<br />\n" +
            "start<br />\n" +
            ";;<br />\n" +
            "stop)<br />\n" +
            "stop<br />\n" +
            ";;<br />\n" +
            "restart)<br />\n" +
            "configtest -q || exit $RETVAL<br />\n" +
            "stop<br />\n" +
            "start<br />\n" +
            ";;<br />\n" +
            "configtest)<br />\n" +
            "configtest<br />\n" +
            ";;<br />\n" +
            "*)<br />\n" +
            "echo $&#8221;Usage: $prog {start|stop|restart|help|configtest}&#8221;<br />\n" +
            "RETVAL=2<br />\n" +
            "esac</p>\n" +
            "<p>exit $RETVAL</p></blockquote>\n" +
            "\n" +
            "<div class=\"wpcnt\">\n" +
            "<div class=\"wpa\">\n" +
            "<a class=\"wpa-about\" href=\"http://wordpress.com/about-these-ads/\" rel=\"nofollow\">About these ads</a>\n" +
            "<script type=\"text/javascript\">\n" +
            "\t\tvar wpcom_adclk_hovering = false;\n" +
            "\t\tvar wpcom_adclk_recorded = false;\n" +
            "\t\tvar wpcom_adclk_theme = \"Minnow\";\n" +
            "\t\tvar wpcom_adclk_slot = \"wpcom_below_post\";\n" +
            "\t\tvar wpcom_adclk_network = ( typeof wpcom_adclk_network === \"undefined\" ) ? \"\" : wpcom_adclk_network ;\n" +
            "\n" +
            "\t\tjQuery(document).ready( function() {\n" +
            "\t\t\tfunction wpcom_adclk_hover_yes() { wpcom_adclk_hovering = true; }\n" +
            "\t\t\tfunction wpcom_adclk_hover_no() { wpcom_adclk_hovering = false; }\n" +
            "\t\t\tjQuery(\".wpa\").click(wpcom_adclk_click);\n" +
            "\t\t\tjQuery(\".wpa iframe\").hover( wpcom_adclk_hover_yes, wpcom_adclk_hover_no );\n" +
            "\t\t\tjQuery(\".wpa object\").hover( wpcom_adclk_hover_yes, wpcom_adclk_hover_no );\n" +
            "\n" +
            "\t\t\tjQuery(window).blur( function() {\n" +
            "\t\t\t\tif ( wpcom_adclk_hovering ) { wpcom_adclk_click(); }\n" +
            "\t\t\t});\n" +
            "\t\t});\n" +
            "\n" +
            "\t\tfunction wpcom_adclk_impression() {\n" +
            "\t\t\tvar stat_gif = document.location.protocol + \"//pixel.wp.com/g.gif?v=wpcom-no-pv\";\n" +
            "\t\t\tstat_gif += \"&x_ads_imp_theme=\" + wpcom_adclk_theme;\n" +
            "\t\t\tstat_gif += \"&x_ads_imp_placement=\"+wpcom_adclk_slot;\n" +
            "\t\t\tstat_gif += \"&x_ads_imp_network=\" + wpcom_adclk_network;\n" +
            "\t\t\tstat_gif += \"&x_ads_imp_theme_network=\"+wpcom_adclk_theme+\"_\"+wpcom_adclk_network;\n" +
            "\t\t\tnew Image().src = stat_gif + \"&baba=\" + Math.random();\n" +
            "\t\t\treturn true;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\tfunction wpcom_adclk_click() {\n" +
            "\t\t\tif (wpcom_adclk_recorded) { return true; } // no double counting\n" +
            "\t\t\tvar stat_gif = document.location.protocol + \"//pixel.wp.com/g.gif?v=wpcom-no-pv\";\n" +
            "\t\t\tstat_gif += \"&x_ads_click_theme=\" + wpcom_adclk_theme;\n" +
            "\t\t\tstat_gif += \"&x_ads_click_placement=\"+wpcom_adclk_slot;\n" +
            "\t\t\tstat_gif += \"&x_ads_click_network=\" + wpcom_adclk_network;\n" +
            "\t\t\tstat_gif += \"&x_ads_click_theme_network=\"+wpcom_adclk_theme+\"_\"+wpcom_adclk_network;\n" +
            "\n" +
            "\t\t\tnew Image().src = stat_gif + \"&baba=\" + Math.random();\n" +
            "\t\t\twpcom_adclk_recorded = true;\n" +
            "\t\t\tvar now=new Date(); var end=now.getTime()+250;\n" +
            "\t\t\twhile(true){now=new Date();if(now.getTime()>end){break;}}\n" +
            "\t\t\treturn true;\n" +
            "\t\t}\n" +
            "\t\n" +
            "if ( typeof GA_googleAddAttr == 'function' ) {\n" +
            "GA_googleAddAttr(\"Origin\", \"other\");\n" +
            "GA_googleAddAttr(\"LangId\", \"1\");\n" +
            "GA_googleAddAttr(\"Domain\", \"refactoringfactory.wordpress.com\");\n" +
            "GA_googleAddAttr(\"BlogId\", \"38709636\");\n" +
            "GA_googleAddAttr(\"PageURL\", \"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/\");\n" +
            "GA_googleAddAttr(\"Autotag\", \"technology\");\n" +
            "GA_googleAddAdSensePageAttr(\"google_page_url\", \"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/\");\n" +
            "GA_googleFillSlot(\"wpcom_below_post\");\n" +
            "}\n" +
            "</script></div></div><div id=\"jp-post-flair\" class=\"sharedaddy sd-like-enabled sd-sharing-enabled\"><div class=\"sharedaddy sd-sharing-enabled\"><div class=\"robots-nocontent sd-block sd-social sd-social-icon-text sd-sharing\"><h3 class=\"sd-title\">Share this:</h3><div class=\"sd-content\"><ul><li class=\"share-twitter\"><a rel=\"nofollow\" data-shared=\"sharing-twitter-1353\" class=\"share-twitter sd-button share-icon\" href=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/?share=twitter\" target=\"_blank\" title=\"Click to share on Twitter\"><span>Twitter</span></a></li><li class=\"share-facebook\"><a rel=\"nofollow\" data-shared=\"sharing-facebook-1353\" class=\"share-facebook sd-button share-icon\" href=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/?share=facebook\" target=\"_blank\" title=\"Share on Facebook\"><span>Facebook</span></a></li><li class=\"share-end\"></li></ul></div></div></div><div class='sharedaddy sd-block sd-like jetpack-likes-widget-wrapper jetpack-likes-widget-unloaded' id='like-post-wrapper-38709636-1353-55870bead5fd6' data-src='//widgets.wp.com/likes/#blog_id=38709636&amp;post_id=1353&amp;origin=refactoringfactory.wordpress.com&amp;obj_id=38709636-1353-55870bead5fd6' data-name='like-post-frame-38709636-1353-55870bead5fd6'><h3 class='sd-title'>Like this:</h3><div class='likes-widget-placeholder post-likes-widget-placeholder' style='height:55px'><span class='button'><span>Like</span></span> <span class=\"loading\">Loading...</span></div><span class='sd-text-color'></span><a class='sd-link-color'></a></div>\n" +
            "<div id='jp-relatedposts' class='jp-relatedposts' >\n" +
            "\t<h3 class=\"jp-relatedposts-headline\"><em>Related</em></h3>\n" +
            "</div></div>\t\t\t</div><!-- .entry-content -->\n" +
            "\n" +
            "\t<div class=\"entry-format\">\n" +
            "\t\t<a href=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/\"><span class=\"screen-reader-text\">RHEL nginx init.d&nbsp;Script</span></a>\t</div>\n" +
            "</article><!-- #post-## -->\n" +
            "\n" +
            "\t\t\t\t<nav class=\"navigation post-navigation\" role=\"navigation\">\n" +
            "\t\t<h1 class=\"screen-reader-text\">Post navigation</h1>\n" +
            "\t\t<div class=\"nav-links\">\n" +
            "\t\t\t<div class=\"nav-previous\"><a href=\"https://refactoringfactory.wordpress.com/2015/01/23/how-to-make-an-sbt-project-that-can-run-in-play-or-a-plain-java-project/\" rel=\"prev\"><span class=\"meta-nav\">&larr;</span>&nbsp;How to Make An SBT Project that Can Run In Play or a Plain Java&nbsp;Project</a></div>\t\t</div><!-- .nav-links -->\n" +
            "\t</nav><!-- .navigation -->\n" +
            "\t\n" +
            "\t\t\t\n" +
            "<div id=\"comments\" class=\"comments-area\">\n" +
            "\n" +
            "\t\n" +
            "\t\n" +
            "\t\n" +
            "\t\t\t\t\t\t\t<div id=\"respond\" class=\"comment-respond\">\n" +
            "\t\t\t\t<h3 id=\"reply-title\" class=\"comment-reply-title\">Leave a Reply <small><a rel=\"nofollow\" id=\"cancel-comment-reply-link\" href=\"/2015/02/03/rhel-nginx-init-d-script/#respond\" style=\"display:none;\">Cancel reply</a></small></h3>\n" +
            "\t\t\t\t\t\t\t\t\t<form action=\"https://refactoringfactory.wordpress.com/wp-comments-post.php\" method=\"post\" id=\"commentform\" class=\"comment-form\" novalidate>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
            "\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"highlander_comment_nonce\" name=\"highlander_comment_nonce\" value=\"b2496a0f38\" /><input type=\"hidden\" name=\"_wp_http_referer\" value=\"/2015/02/03/rhel-nginx-init-d-script/\" />\n" +
            "<input type=\"hidden\" name=\"hc_post_as\" id=\"hc_post_as\" value=\"guest\" />\n" +
            "\n" +
            "<div class=\"comment-form-field comment-textarea\">\n" +
            "\t<label for=\"comment\">Enter your comment here...</label>\n" +
            "\t<div id=\"comment-form-comment\"><textarea id=\"comment\" name=\"comment\" title=\"Enter your comment here...\"></textarea></div>\n" +
            "</div>\n" +
            "\n" +
            "<div id=\"comment-form-identity\">\n" +
            "\n" +
            "\t<div id=\"comment-form-nascar\">\n" +
            "\t\t<p>Fill in your details below or click an icon to log in:</p>\n" +
            "\t\t<ul>\n" +
            "\t\t\t<li class=\"selected\" style=\"display:none;\">\n" +
            "\t\t\t\t<a href=\"#comment-form-guest\" id=\"postas-guest\" title=\"Guest\">\n" +
            "\t\t\t\t\t<span></span>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li>\n" +
            "\t\t\t\t<a href=\"#comment-form-load-service:WordPress.com\" id=\"postas-wordpress\" title=\"WordPress.com\">\n" +
            "\t\t\t\t\t<span></span>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li>\n" +
            "\t\t\t\t<a href=\"#comment-form-load-service:Twitter\" id=\"postas-twitter\" title=\"Twitter\">\n" +
            "\t\t\t\t\t<span></span>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li>\n" +
            "\t\t\t\t<a href=\"#comment-form-load-service:Facebook\" id=\"postas-facebook\" title=\"Facebook\">\n" +
            "\t\t\t\t\t<span></span>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li>\n" +
            "\t\t\t<iframe id=\"googleplus-sign-in\" name=\"googleplus-sign-in\" src=\"https://public-api.wordpress.com/connect/?googleplus-sign-in=https%3A%2F%2Frefactoringfactory.wordpress.com\" width=\"24\" height=\"24\" scrolling=\"no\" allowtransparency=\"true\" seamless=\"seamless\" frameborder=\"0\"></iframe>\n" +
            "\t\t\t</li>\n" +
            "\t\t</ul>\n" +
            "\t</div>\n" +
            "\n" +
            "\t<div id=\"comment-form-guest\" class=\"comment-form-service selected\">\n" +
            "\t\t<div class=\"comment-form-padder\">\n" +
            "\t\t\t<div class=\"comment-form-avatar\">\n" +
            "<a href=\"https://gravatar.com/site/signup/\" target=\"_blank\">\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Gravatar\" width=\"25\" class=\"no-grav\" />\n" +
            "</a>\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t<div class=\"comment-form-fields\">\n" +
            "\t\t\t\t<div class=\"comment-form-field comment-form-email\">\n" +
            "\t\t\t\t\t<label for=\"email\">Email <span class=\"required\">(required)</span> <span class=\"nopublish\">(Address never made public)</span></label>\n" +
            "\t\t\t\t\t<div class=\"comment-form-input\"><input id=\"email\" name=\"email\" type=\"email\" value=\"\" /></div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<div class=\"comment-form-field comment-form-author\">\n" +
            "\t\t\t\t\t<label for=\"author\">Name <span class=\"required\">(required)</span></label>\n" +
            "\t\t\t\t\t<div class=\"comment-form-input\"><input id=\"author\" name=\"author\" type=\"text\" value=\"\" /></div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<div class=\"comment-form-field comment-form-url\">\n" +
            "\t\t\t\t\t<label for=\"url\">Website</label>\n" +
            "\t\t\t\t\t<div class=\"comment-form-input\"><input id=\"url\" name=\"url\" type=\"text\" value=\"\" /></div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\n" +
            "\t<div id=\"comment-form-wordpress\" class=\"comment-form-service\">\n" +
            "\t\t<div class=\"comment-form-padder\">\n" +
            "\t\t\t<div class=\"comment-form-avatar\">\n" +
            "\t\t\t\t<img src=\"https://s2.wp.com/wp-content/mu-plugins/highlander-comments/images/wplogo.png\" alt=\"WordPress.com Logo\" width=\"25\" class=\"no-grav\" />\n" +
            "\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t<div class=\"comment-form-fields\">\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"wp_avatar\" id=\"wordpress-avatar\" class=\"comment-meta-wordpress\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"wp_user_id\" id=\"wordpress-user_id\" class=\"comment-meta-wordpress\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"wp_access_token\" id=\"wordpress-access_token\" class=\"comment-meta-wordpress\" value=\"\" />\n" +
            "\t\t\t\t<p class=\"comment-form-posting-as pa-wordpress\"><strong></strong> You are commenting using your WordPress.com account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'wordpress' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n" +
            "\t\t\t</div>\n" +
            "\t\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\n" +
            "\t<div id=\"comment-form-twitter\" class=\"comment-form-service\">\n" +
            "\t\t<div class=\"comment-form-padder\">\n" +
            "\t\t\t<div class=\"comment-form-avatar\">\n" +
            "\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Twitter picture\" width=\"25\" class=\"no-grav\" />\n" +
            "\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t<div class=\"comment-form-fields\">\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"twitter_avatar\" id=\"twitter-avatar\" class=\"comment-meta-twitter\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"twitter_user_id\" id=\"twitter-user_id\" class=\"comment-meta-twitter\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"twitter_access_token\" id=\"twitter-access_token\" class=\"comment-meta-twitter\" value=\"\" />\n" +
            "\t\t\t\t<p class=\"comment-form-posting-as pa-twitter\"><strong></strong> You are commenting using your Twitter account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'twitter' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n" +
            "\t\t\t</div>\n" +
            "\t\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\n" +
            "\t<div id=\"comment-form-facebook\" class=\"comment-form-service\">\n" +
            "\t\t<div class=\"comment-form-padder\">\n" +
            "\t\t\t<div class=\"comment-form-avatar\">\n" +
            "\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Facebook photo\" width=\"25\" class=\"no-grav\" />\n" +
            "\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t<div class=\"comment-form-fields\">\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"fb_avatar\" id=\"facebook-avatar\" class=\"comment-meta-facebook\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"fb_user_id\" id=\"facebook-user_id\" class=\"comment-meta-facebook\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"fb_access_token\" id=\"facebook-access_token\" class=\"comment-meta-facebook\" value=\"\" />\n" +
            "\t\t\t\t<p class=\"comment-form-posting-as pa-facebook\"><strong></strong> You are commenting using your Facebook account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'facebook' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n" +
            "\t\t\t</div>\n" +
            "\t\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\n" +
            "\t<div id=\"comment-form-googleplus\" class=\"comment-form-service\">\n" +
            "\t\t<div class=\"comment-form-padder\">\n" +
            "\t\t\t<div class=\"comment-form-avatar\">\n" +
            "\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Google+ photo\" width=\"25\" class=\"no-grav\" />\n" +
            "\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t<div class=\"comment-form-fields\">\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"googleplus_avatar\" id=\"googleplus-avatar\" class=\"comment-meta-googleplus\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"googleplus_user_id\" id=\"googleplus-user_id\" class=\"comment-meta-googleplus\" value=\"\" />\n" +
            "\t\t\t\t<input type=\"hidden\" name=\"googleplus_access_token\" id=\"googleplus-access_token\" class=\"comment-meta-googleplus\" value=\"\" />\n" +
            "\t\t\t\t<p class=\"comment-form-posting-as pa-googleplus\"><strong></strong> You are commenting using your Google+ account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'googleplus' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n" +
            "\t\t\t</div>\n" +
            "\t\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\n" +
            "\n" +
            "\t<div id=\"comment-form-load-service\" class=\"comment-form-service\">\n" +
            "\t\t<div class=\"comment-form-posting-as-cancel\"><a href=\"javascript:HighlanderComments.cancelExternalWindow();\">Cancel</a></div>\n" +
            "\t\t<p>Connecting to %s</p>\n" +
            "\t</div>\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "var highlander_expando_javascript = function(){\n" +
            "\tvar input = document.createElement( 'input' ),\n" +
            "\t    comment = jQuery( '#comment' );\n" +
            "\n" +
            "\tif ( 'placeholder' in input ) {\n" +
            "\t\tcomment.attr( 'placeholder', jQuery( '.comment-textarea label' ).remove().text() );\n" +
            "\t}\n" +
            "\n" +
            "\t// Expando Mode: start small, then auto-resize on first click + text length\n" +
            "\tjQuery( '#comment-form-identity' ).hide();\n" +
            "\tjQuery( '#comment-form-subscribe' ).hide();\n" +
            "\tjQuery( '#commentform .form-submit' ).hide();\n" +
            "\n" +
            "\tcomment.css( { 'height':'10px' } ).one( 'focus', function() {\n" +
            "\t\tvar timer = setInterval( HighlanderComments.resizeCallback, 10 )\n" +
            "\t\tjQuery( this ).animate( { 'height': HighlanderComments.initialHeight } ).delay( 100 ).queue( function(n) { clearInterval( timer ); HighlanderComments.resizeCallback(); n(); } );\n" +
            "\t\tjQuery( '#comment-form-identity' ).slideDown();\n" +
            "\t\tjQuery( '#comment-form-subscribe' ).slideDown();\n" +
            "\t\tjQuery( '#commentform .form-submit' ).slideDown();\n" +
            "\t});\n" +
            "}\n" +
            "jQuery(document).ready( highlander_expando_javascript );\n" +
            "</script>\n" +
            "\n" +
            "<div id=\"comment-form-subscribe\">\n" +
            "\t<p class=\"comment-subscription-form\"><input type=\"checkbox\" name=\"subscribe\" id=\"subscribe\" value=\"subscribe\" style=\"width: auto;\" tabindex=\"6\"/> <label class=\"subscribe-label\" id=\"subscribe-label\" for=\"subscribe\" style=\"display: inline;\">Notify me of new comments via email.</label></p></div>\n" +
            "\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t\t<p class=\"form-submit\"><input name=\"submit\" type=\"submit\" id=\"comment-submit\" class=\"submit\" value=\"Post Comment\" /> <input type='hidden' name='comment_post_ID' value='1353' id='comment_post_ID' />\n" +
            "<input type='hidden' name='comment_parent' id='comment_parent' value='0' />\n" +
            "</p><p style=\"display: none;\"><input type=\"hidden\" id=\"akismet_comment_nonce\" name=\"akismet_comment_nonce\" value=\"715bbc8815\" /></p>\n" +
            "<input type=\"hidden\" name=\"genseq\" value=\"1434913770\" />\n" +
            "<p style=\"display: none;\"><input type=\"hidden\" id=\"ak_js\" name=\"ak_js\" value=\"70\"/></p>\t\t\t\t\t</form>\n" +
            "\t\t\t\t\t\t\t</div><!-- #respond -->\n" +
            "\t\t\t<div style=\"clear: both\"></div>\n" +
            "</div><!-- #comments -->\n" +
            "\n" +
            "\t\t\n" +
            "\t\t</main><!-- #main -->\n" +
            "\t</div><!-- #primary -->\n" +
            "\n" +
            "\n" +
            "\t</div><!-- #content -->\n" +
            "\n" +
            "\t<footer id=\"colophon\" class=\"site-footer\" role=\"contentinfo\">\n" +
            "\t\t<div class=\"site-info\">\n" +
            "\t\t\t<a href=\"https://wordpress.com/?ref=footer_website\">Create a free website or blog at WordPress.com</a>.\n" +
            "\t\t\t<span class=\"sep\"> | </span>\n" +
            "\t\t\t<a href=\"https://wordpress.com/themes/minnow/\" title=\"Learn more about this theme\">The Minnow Theme</a>.\t\t</div><!-- .site-info -->\n" +
            "\t</footer><!-- #colophon -->\n" +
            "</div><!-- #page -->\n" +
            "\n" +
            "<!-- wpcom_wp_footer -->\n" +
            "<script type='text/javascript' src='//0.gravatar.com/js/gprofiles.js?ver=201525x'></script>\n" +
            "<script type='text/javascript'>\n" +
            "/* <![CDATA[ */\n" +
            "var WPGroHo = {\"my_hash\":\"\"};\n" +
            "/* ]]> */\n" +
            "</script>\n" +
            "<script type='text/javascript' src='https://s2.wp.com/wp-content/mu-plugins/gravatar-hovercards/wpgroho.js?m=1380573781g'></script>\n" +
            "\n" +
            "\t<script>\n" +
            "\t\t//initialize and attach hovercards to all gravatars\n" +
            "\t\tjQuery( document ).ready( function( $ ) {\n" +
            "\n" +
            "\t\t\tif (typeof Gravatar === \"undefined\"){\n" +
            "\t\t\t\treturn;\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\tif ( typeof Gravatar.init !== \"function\" ) {\n" +
            "\t\t\t\treturn;\n" +
            "\t\t\t}\t\t\t\n" +
            "\n" +
            "\t\t\tGravatar.profile_cb = function( hash, id ) {\n" +
            "\t\t\t\tWPGroHo.syncProfileData( hash, id );\n" +
            "\t\t\t};\n" +
            "\t\t\tGravatar.my_hash = WPGroHo.my_hash;\n" +
            "\t\t\tGravatar.init( 'body', '#wp-admin-bar-my-account' );\n" +
            "\t\t});\n" +
            "\t</script>\n" +
            "\n" +
            "\t\t<div style=\"display:none\">\n" +
            "\t</div>\n" +
            "<script type='text/javascript'>\n" +
            "/* <![CDATA[ */\n" +
            "var HighlanderComments = {\"loggingInText\":\"Logging In\\u2026\",\"submittingText\":\"Posting Comment\\u2026\",\"postCommentText\":\"Post Comment\",\"connectingToText\":\"Connecting to %s\",\"commentingAsText\":\"%1$s: You are commenting using your %2$s account.\",\"logoutText\":\"Log Out\",\"loginText\":\"Log In\",\"connectURL\":\"https:\\/\\/refactoringfactory.wordpress.com\\/public.api\\/connect\\/?action=request\",\"logoutURL\":\"https:\\/\\/refactoringfactory.wordpress.com\\/wp-login.php?action=logout&_wpnonce=6efbdca663\",\"homeURL\":\"https:\\/\\/refactoringfactory.wordpress.com\\/\",\"postID\":\"1353\",\"gravDefault\":\"identicon\",\"enterACommentError\":\"Please enter a comment\",\"enterEmailError\":\"Please enter your email address here\",\"invalidEmailError\":\"Invalid email address\",\"enterAuthorError\":\"Please enter your name here\",\"gravatarFromEmail\":\"This picture will show whenever you leave a comment. Click to customize it.\",\"logInToExternalAccount\":\"Log in to use details from one of these accounts.\",\"change\":\"Change\",\"changeAccount\":\"Change Account\",\"comment_registration\":\"0\",\"userIsLoggedIn\":\"\",\"isJetpack\":\"0\",\"text_direction\":\"ltr\"};\n" +
            "/* ]]> */\n" +
            "</script>\n" +
            "<script type='text/javascript' src='https://s2.wp.com/_static/??/wp-content/js/jquery/jquery.autoresize.js,/wp-content/mu-plugins/highlander-comments/script.js?m=1424115551j'></script>\n" +
            "\n" +
            "\t<div id=\"bit\" class=\"loggedout-follow-normal\">\n" +
            "\t\t<a class=\"bsub\" href=\"javascript:void(0)\"><span id='bsub-text'>Follow</span></a>\n" +
            "\t\t<div id=\"bitsubscribe\">\n" +
            "\n" +
            "\t\t\t\t\t<h3><label for=\"loggedout-follow-field\">Follow &ldquo;refactoringFactory(jason.goodwin)&rdquo;</label></h3>\n" +
            "\n" +
            "\t\t\t<form action=\"https://subscribe.wordpress.com\" method=\"post\" accept-charset=\"utf-8\" id=\"loggedout-follow\">\n" +
            "\t\t\t<p>Get every new post delivered to your Inbox.</p>\n" +
            "\n" +
            "\t\t\t<p id=\"loggedout-follow-error\" style=\"display: none;\"></p>\n" +
            "\n" +
            "\t\t\t\n" +
            "\t\t\t<p><input type=\"email\" name=\"email\" value=\"Enter your email address\" onfocus='this.value=(this.value==\"Enter your email address\") ? \"\" : this.value;' onblur='this.value=(this.value==\"\") ? \"Enter your email address\" : this.value;'  id=\"loggedout-follow-field\"/></p>\n" +
            "\n" +
            "\t\t\t<input type=\"hidden\" name=\"action\" value=\"subscribe\"/>\n" +
            "\t\t\t<input type=\"hidden\" name=\"blog_id\" value=\"38709636\"/>\n" +
            "\t\t\t<input type=\"hidden\" name=\"source\" value=\"https://refactoringfactory.wordpress.com/2015/02/03/rhel-nginx-init-d-script/\"/>\n" +
            "\t\t\t<input type=\"hidden\" name=\"sub-type\" value=\"loggedout-follow\"/>\n" +
            "\n" +
            "\t\t\t<input type=\"hidden\" id=\"_wpnonce\" name=\"_wpnonce\" value=\"709ef85c26\" /><input type=\"hidden\" name=\"_wp_http_referer\" value=\"/2015/02/03/rhel-nginx-init-d-script/\" />\n" +
            "\t\t\t<p id='bsub-subscribe-button'><input type=\"submit\" value=\"Sign me up\" /></p>\n" +
            "\t\t\t</form>\n" +
            "\t\t\t\t\t<div id='bsub-credit'><a href=\"https://wordpress.com/?ref=lof\">Build a website with WordPress.com</a></div>\n" +
            "\t\t</div><!-- #bitsubscribe -->\n" +
            "\t</div><!-- #bit -->\n" +
            "\n" +
            "\t<script type=\"text/javascript\">\n" +
            "\t\twindow.WPCOM_sharing_counts = {\"https:\\/\\/refactoringfactory.wordpress.com\\/2015\\/02\\/03\\/rhel-nginx-init-d-script\\/\":1353};\n" +
            "\t\twindow.WPCOM_jetpack = false;\n" +
            "\t\t\t\twindow.WPCOM_site_ID = 38709636;\n" +
            "\t\t\t</script>\n" +
            "\t\t<script type=\"text/javascript\">\n" +
            "\t\t\tvar windowOpen;\n" +
            "\t\tjQuery(document).on( 'ready post-load', function(){\n" +
            "\t\t\tjQuery( 'a.share-twitter' ).on( 'click', function() {\n" +
            "\t\t\t\tif ( 'undefined' !== typeof windowOpen ){ // If there's another sharing window open, close it.\n" +
            "\t\t\t\t\twindowOpen.close();\n" +
            "\t\t\t\t}\n" +
            "\t\t\t\twindowOpen = window.open( jQuery(this).attr( 'href' ), 'wpcomtwitter', 'menubar=1,resizable=1,width=600,height=350' );\n" +
            "\t\t\t\treturn false;\n" +
            "\t\t\t});\n" +
            "\t\t});\n" +
            "\t\t</script>\n" +
            "\t\t\t\t<script type=\"text/javascript\">\n" +
            "\t\t\tvar windowOpen;\n" +
            "\t\tjQuery(document).on( 'ready post-load', function(){\n" +
            "\t\t\tjQuery( 'a.share-facebook' ).on( 'click', function() {\n" +
            "\t\t\t\tif ( 'undefined' !== typeof windowOpen ){ // If there's another sharing window open, close it.\n" +
            "\t\t\t\t\twindowOpen.close();\n" +
            "\t\t\t\t}\n" +
            "\t\t\t\twindowOpen = window.open( jQuery(this).attr( 'href' ), 'wpcomfacebook', 'menubar=1,resizable=1,width=600,height=400' );\n" +
            "\t\t\t\treturn false;\n" +
            "\t\t\t});\n" +
            "\t\t});\n" +
            "\t\t</script>\n" +
            "\t\t\t\t<iframe src='https://widgets.wp.com/likes/master.html?ver=20141028#ver=20141028&amp;mp6=1' scrolling='no' id='likes-master' name='likes-master' style='display:none;'></iframe>\n" +
            "\t\t<div id='likes-other-gravatars'><div class=\"likes-text\"><span>%d</span> bloggers like this:</div><ul class=\"wpl-avatars sd-like-gravatars\"></ul></div>\n" +
            "\t\t<script type=\"text/javascript\">\n" +
            "\t\t//<![CDATA[\n" +
            "\t\t\tvar jetpackLikesWidgetQueue = [];\n" +
            "\t\t\tvar jetpackLikesWidgetBatch = [];\n" +
            "\t\t\tvar jetpackLikesMasterReady = false;\n" +
            "\n" +
            "\t\t\tfunction JetpackLikespostMessage( message, target ) {\n" +
            "\t\t\t\tif ( \"string\" === typeof message ){\n" +
            "\t\t\t\t\ttry{\n" +
            "\t\t\t\t\t\tmessage = JSON.parse( message );\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t\tcatch(e) {\n" +
            "\t\t\t\t\t\treturn;\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tpm( {\n" +
            "\t\t\t\t\ttarget: target,\n" +
            "\t\t\t\t\ttype: 'likesMessage',\n" +
            "\t\t\t\t\tdata: message,\n" +
            "\t\t\t\t\torigin: '*'\n" +
            "\t\t\t\t} );\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\tfunction JetpackLikesBatchHandler() {\n" +
            "\t\t\t\tvar requests = [];\n" +
            "\t\t\t\tjQuery( 'div.jetpack-likes-widget-unloaded' ).each( function( i ) {\n" +
            "\t\t\t\t\tif ( jetpackLikesWidgetBatch.indexOf( this.id ) > -1 )\n" +
            "\t\t\t\t\t\treturn;\n" +
            "\t\t\t\t\tjetpackLikesWidgetBatch.push( this.id );\n" +
            "\t\t\t\t\tvar regex = /like-(post|comment)-wrapper-(\\d+)-(\\d+)-(\\w+)/;\n" +
            "\t\t\t\t\tvar match = regex.exec( this.id );\n" +
            "\t\t\t\t\tif ( ! match || match.length != 5 )\n" +
            "\t\t\t\t\t\treturn;\n" +
            "\n" +
            "\t\t\t\t\tvar info = {\n" +
            "\t\t\t\t\t\tblog_id: match[2],\n" +
            "\t\t\t\t\t\twidth:   this.width\n" +
            "\t\t\t\t\t};\n" +
            "\n" +
            "\t\t\t\t\tif ( 'post' == match[1] ) {\n" +
            "\t\t\t\t\t\tinfo.post_id = match[3];\n" +
            "\t\t\t\t\t} else if ( 'comment' == match[1] ) {\n" +
            "\t\t\t\t\t\tinfo.comment_id = match[3];\n" +
            "\t\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\t\tinfo.obj_id = match[4];\n" +
            "\n" +
            "\t\t\t\t\trequests.push( info );\n" +
            "\t\t\t\t});\n" +
            "\n" +
            "\t\t\t\tif ( requests.length > 0 ) {\n" +
            "\t\t\t\t\tJetpackLikespostMessage( { event: 'initialBatch', requests: requests }, window.frames['likes-master'] );\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\tfunction JetpackLikesMessageListener( event ) {\n" +
            "\t\t\t\tif ( \"undefined\" == typeof event.event )\n" +
            "\t\t\t\t\treturn;\n" +
            "\n" +
            "\t\t\t\tif ( 'masterReady' == event.event ) {\n" +
            "\t\t\t\t\tjQuery( document ).ready( function() {\n" +
            "\t\t\t\t\t\tjetpackLikesMasterReady = true;\n" +
            "\n" +
            "\t\t\t\t\t\tvar stylesData = {\n" +
            "\t\t\t\t\t\t\t\tevent: 'injectStyles'\n" +
            "\t\t\t\t\t\t};\n" +
            "\n" +
            "\t\t\t\t\t\tif ( jQuery( 'iframe.admin-bar-likes-widget' ).length > 0 ) {\n" +
            "\t\t\t\t\t\t\tJetpackLikespostMessage( { event: 'adminBarEnabled' }, window.frames[ 'likes-master' ] );\n" +
            "\n" +
            "\t\t\t\t\t\t\tstylesData.adminBarStyles = {\n" +
            "\t\t\t\t\t\t\t\tbackground: jQuery( '#wpadminbar .quicklinks li#wp-admin-bar-wpl-like > a' ).css( 'background' ),\n" +
            "\t\t\t\t\t\t\t\tisRtl: ( 'rtl' == jQuery( '#wpadminbar' ).css( 'direction' ) )\n" +
            "\t\t\t\t\t\t\t};\n" +
            "\t\t\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\t\t\tif ( !window.addEventListener )\n" +
            "\t\t\t\t\t\t\tjQuery( '#wp-admin-bar-admin-bar-likes-widget' ).hide();\n" +
            "\n" +
            "\t\t\t\t\t\tstylesData.textStyles = {\n" +
            "\t\t\t\t\t\t\tcolor: jQuery( '.sd-text-color').css( 'color' ),\n" +
            "\t\t\t\t\t\t\tfontFamily: jQuery( '.sd-text-color' ).css( 'font-family' ),\n" +
            "\t\t\t\t\t\t\tfontSize: jQuery( '.sd-text-color' ).css( 'font-size' ),\n" +
            "\t\t\t\t\t\t\tdirection: jQuery( '.sd-text-color' ).css( 'direction' ),\n" +
            "\t\t\t\t\t\t\tfontWeight: jQuery( '.sd-text-color' ).css( 'font-weight' ),\n" +
            "\t\t\t\t\t\t\tfontStyle: jQuery( '.sd-text-color' ).css( 'font-style' ),\n" +
            "\t\t\t\t\t\t\ttextDecoration: jQuery( '.sd-text-color' ).css('text-decoration')\n" +
            "\t\t\t\t\t\t};\n" +
            "\n" +
            "\t\t\t\t\t\tstylesData.linkStyles = {\n" +
            "\t\t\t\t\t\t\tcolor: jQuery( '.sd-link-color' ).css('color'),\n" +
            "\t\t\t\t\t\t\tfontFamily: jQuery( '.sd-link-color' ).css('font-family'),\n" +
            "\t\t\t\t\t\t\tfontSize: jQuery( '.sd-link-color' ).css('font-size'),\n" +
            "\t\t\t\t\t\t\ttextDecoration: jQuery( '.sd-link-color' ).css('text-decoration'),\n" +
            "\t\t\t\t\t\t\tfontWeight: jQuery( '.sd-link-color' ).css( 'font-weight' ),\n" +
            "\t\t\t\t\t\t\tfontStyle: jQuery( '.sd-link-color' ).css( 'font-style' )\n" +
            "\t\t\t\t\t\t};\n" +
            "\n" +
            "\t\t\t\t\t\tJetpackLikespostMessage( stylesData, window.frames[ 'likes-master' ] );\n" +
            "\n" +
            "\t\t\t\t\t\tJetpackLikesBatchHandler();\n" +
            "\n" +
            "\t\t\t\t\t\tjQuery( document ).on( 'inview', 'div.jetpack-likes-widget-unloaded', function() {\n" +
            "\t\t\t\t\t\t\tjetpackLikesWidgetQueue.push( this.id );\n" +
            "\t\t\t\t\t\t});\n" +
            "\t\t\t\t\t});\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tif ( 'showLikeWidget' == event.event ) {\n" +
            "\t\t\t\t\tjQuery( '#' + event.id + ' .post-likes-widget-placeholder'  ).fadeOut( 'fast', function() {\n" +
            "\t\t\t\t\t\tjQuery( '#' + event.id + ' .post-likes-widget' ).fadeIn( 'fast', function() {\n" +
            "\t\t\t\t\t\t\tJetpackLikespostMessage( { event: 'likeWidgetDisplayed', blog_id: event.blog_id, post_id: event.post_id, obj_id: event.obj_id }, window.frames['likes-master'] );\n" +
            "\t\t\t\t\t\t});\n" +
            "\t\t\t\t\t});\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tif ( 'clickReblogFlair' == event.event ) {\n" +
            "\t\t\t\t\twpcom_reblog.toggle_reblog_box_flair( event.obj_id );\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tif ( 'showOtherGravatars' == event.event ) {\n" +
            "\t\t\t\t\tvar $container = jQuery( '#likes-other-gravatars' );\n" +
            "\t\t\t\t\tvar $list = $container.find( 'ul' );\n" +
            "\n" +
            "\t\t\t\t\t$container.hide();\n" +
            "\t\t\t\t\t$list.html( '' );\n" +
            "\n" +
            "\t\t\t\t\t$container.find( '.likes-text span' ).text( event.total );\n" +
            "\n" +
            "\t\t\t\t\tjQuery.each( event.likers, function( i, liker ) {\n" +
            "\t\t\t\t\t\t$list.append( '<li class=\"' + liker.css_class + '\"><a href=\"' + liker.profile_URL + '\" class=\"wpl-liker\" rel=\"nofollow\" target=\"_parent\"><img src=\"' + liker.avatar_URL + '\" alt=\"' + liker.name + '\" width=\"30\" height=\"30\" style=\"padding-right: 3px;\" /></a></li>');\n" +
            "\t\t\t\t\t} );\n" +
            "\n" +
            "\t\t\t\t\tvar offset = jQuery( \"[name='\" + event.parent + \"']\" ).offset();\n" +
            "\n" +
            "\t\t\t\t\t$container.css( 'left', offset.left + event.position.left - 10 + 'px' );\n" +
            "\t\t\t\t\t$container.css( 'top', offset.top + event.position.top - 33 + 'px' );\n" +
            "\n" +
            "\t\t\t\t\tvar rowLength = Math.floor( event.width / 37 );\n" +
            "\t\t\t\t\tvar height = ( Math.ceil( event.likers.length / rowLength ) * 37 ) + 13;\n" +
            "\t\t\t\t\tif ( height > 204 ) {\n" +
            "\t\t\t\t\t\theight = 204;\n" +
            "\t\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\t\t$container.css( 'height', height + 'px' );\n" +
            "\t\t\t\t\t$container.css( 'width', rowLength * 37 - 7 + 'px' );\n" +
            "\n" +
            "\t\t\t\t\t$list.css( 'width', rowLength * 37 + 'px' );\n" +
            "\n" +
            "\t\t\t\t\t$container.fadeIn( 'slow' );\n" +
            "\n" +
            "\t\t\t\t\tvar scrollbarWidth = $list[0].offsetWidth - $list[0].clientWidth;\n" +
            "\t\t\t\t\tif ( scrollbarWidth > 0 ) {\n" +
            "\t\t\t\t\t\t$container.width( $container.width() + scrollbarWidth );\n" +
            "\t\t\t\t\t\t$list.width( $list.width() + scrollbarWidth );\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\n" +
            "\t\t\tpm.bind( 'likesMessage', function(e) { JetpackLikesMessageListener(e); } );\n" +
            "\n" +
            "\t\t\tjQuery( document ).click( function( e ) {\n" +
            "\t\t\t\tvar $container = jQuery( '#likes-other-gravatars' );\n" +
            "\n" +
            "\t\t\t\tif ( $container.has( e.target ).length === 0 ) {\n" +
            "\t\t\t\t\t$container.fadeOut( 'slow' );\n" +
            "\t\t\t\t}\n" +
            "\t\t\t});\n" +
            "\n" +
            "\t\t\tfunction JetpackLikesWidgetQueueHandler() {\n" +
            "\t\t\t\tvar wrapperID;\n" +
            "\t\t\t\tif ( ! jetpackLikesMasterReady ) {\n" +
            "\t\t\t\t\tsetTimeout( JetpackLikesWidgetQueueHandler, 500 );\n" +
            "\t\t\t\t\treturn;\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tif ( jetpackLikesWidgetQueue.length > 0 ) {\n" +
            "\t\t\t\t\t// We may have a widget that needs creating now\n" +
            "\t\t\t\t\tvar found = false;\n" +
            "\t\t\t\t\twhile( jetpackLikesWidgetQueue.length > 0 ) {\n" +
            "\t\t\t\t\t\t// Grab the first member of the queue that isn't already loading.\n" +
            "\t\t\t\t\t\twrapperID = jetpackLikesWidgetQueue.splice( 0, 1 )[0];\n" +
            "\t\t\t\t\t\tif ( jQuery( '#' + wrapperID ).hasClass( 'jetpack-likes-widget-unloaded' ) ) {\n" +
            "\t\t\t\t\t\t\tfound = true;\n" +
            "\t\t\t\t\t\t\tbreak;\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t\tif ( ! found ) {\n" +
            "\t\t\t\t\t\tsetTimeout( JetpackLikesWidgetQueueHandler, 500 );\n" +
            "\t\t\t\t\t\treturn;\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t} else if ( jQuery( 'div.jetpack-likes-widget-unloaded' ).length > 0 ) {\n" +
            "\t\t\t\t\t// Grab any unloaded widgets for a batch request\n" +
            "\t\t\t\t\tJetpackLikesBatchHandler();\n" +
            "\n" +
            "\t\t\t\t\t// Get the next unloaded widget\n" +
            "\t\t\t\t\twrapperID = jQuery( 'div.jetpack-likes-widget-unloaded' ).first()[0].id;\n" +
            "\t\t\t\t\tif ( ! wrapperID ) {\n" +
            "\t\t\t\t\t\t// Everything is currently loaded\n" +
            "\t\t\t\t\t\tsetTimeout( JetpackLikesWidgetQueueHandler, 500 );\n" +
            "\t\t\t\t\t\treturn;\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tif ( 'undefined' === typeof wrapperID ) {\n" +
            "\t\t\t\t\tsetTimeout( JetpackLikesWidgetQueueHandler, 500 );\n" +
            "\t\t\t\t\treturn;\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\tvar $wrapper = jQuery( '#' + wrapperID );\n" +
            "\t\t\t\t$wrapper.find( 'iframe' ).remove();\n" +
            "\n" +
            "\t\t\t\tif ( $wrapper.hasClass( 'slim-likes-widget' ) ) {\n" +
            "\t\t\t\t\t$wrapper.find( '.post-likes-widget-placeholder' ).after( \"<iframe class='post-likes-widget jetpack-likes-widget' name='\" + $wrapper.data( 'name' ) + \"' height='22px' width='68px' frameBorder='0' scrolling='no' src='\" + $wrapper.data( 'src' ) + \"'></iframe>\" );\n" +
            "\t\t\t\t} else {\n" +
            "\t\t\t\t\t$wrapper.find( '.post-likes-widget-placeholder' ).after( \"<iframe class='post-likes-widget jetpack-likes-widget' name='\" + $wrapper.data( 'name' ) + \"' height='55px' width='100%' frameBorder='0' src='\" + $wrapper.data( 'src' ) + \"'></iframe>\" );\n" +
            "\t\t\t\t}\n" +
            "\n" +
            "\t\t\t\t$wrapper.removeClass( 'jetpack-likes-widget-unloaded' ).addClass( 'jetpack-likes-widget-loading' );\n" +
            "\n" +
            "\t\t\t\t$wrapper.find( 'iframe' ).load( function( e ) {\n" +
            "\t\t\t\t\tvar $iframe = jQuery( e.target );\n" +
            "\t\t\t\t\t$wrapper.removeClass( 'jetpack-likes-widget-loading' ).addClass( 'jetpack-likes-widget-loaded' );\n" +
            "\n" +
            "\t\t\t\t\tJetpackLikespostMessage( { event: 'loadLikeWidget', name: $iframe.attr( 'name' ), width: $iframe.width() }, window.frames[ 'likes-master' ] );\n" +
            "\n" +
            "\t\t\t\t\tif ( $wrapper.hasClass( 'slim-likes-widget' ) ) {\n" +
            "\t\t\t\t\t\t$wrapper.find( 'iframe' ).Jetpack( 'resizeable' );\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t});\n" +
            "\t\t\t\tsetTimeout( JetpackLikesWidgetQueueHandler, 250 );\n" +
            "\t\t\t}\n" +
            "\t\t\tJetpackLikesWidgetQueueHandler();\n" +
            "\t\t//]]>\n" +
            "\t\t</script>\n" +
            "<script type='text/javascript' src='https://s1.wp.com/wp-content/mu-plugins/akismet-3.0/_inc/form.js?m=1404442431g'></script>\n" +
            "<script type='text/javascript'>\n" +
            "/* <![CDATA[ */\n" +
            "var JetpackEmojiSettings = {\"base_url\":\"https:\\/\\/s0.wp.com\\/wp-content\\/mu-plugins\\/emoji\\/twemoji\\/\"};\n" +
            "/* ]]> */\n" +
            "</script>\n" +
            "<script type='text/javascript'>\n" +
            "/* <![CDATA[ */\n" +
            "var sharing_js_options = {\"lang\":\"en\",\"counts\":\"1\"};\n" +
            "/* ]]> */\n" +
            "</script>\n" +
            "<script type='text/javascript' src='https://s0.wp.com/_static/??-eJyNzt0OgjAMBeAXstQ/9Mr4LHMO6Ni6hm2gb++M0ag3cHWa9DtNcRLQgZPhhDbi1YykjdwqG1f4tUqd8Sai5At6Yg7TE7+mRZTVSK1KFHgRjz0JOOIemqBzhIY+HxFrl6+lUZgO3pcbMBhx96rU/4/7DOJySxzR+GAJ0/STs96aJEr3sEzPKQkxQeMUDRg7NRC37yylsz9t9rv9uj5s66N9AKpEl/Q='></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "// <![CDATA[\n" +
            "(function() {\n" +
            "try{\n" +
            "  if ( window.external &&'msIsSiteMode' in window.external) {\n" +
            "    if (window.external.msIsSiteMode()) {\n" +
            "      var jl = document.createElement('script');\n" +
            "      jl.type='text/javascript';\n" +
            "      jl.async=true;\n" +
            "      jl.src='/wp-content/plugins/ie-sitemode/custom-jumplist.php';\n" +
            "      var s = document.getElementsByTagName('script')[0];\n" +
            "      s.parentNode.insertBefore(jl, s);\n" +
            "    }\n" +
            "  }\n" +
            "}catch(e){}\n" +
            "})();\n" +
            "// ]]>\n" +
            "</script>\t<script type=\"text/javascript\">\n" +
            "\tvar skimlinks_pub_id = \"725X584219\"\n" +
            "\tvar skimlinks_sitename = \"refactoringfactory.wordpress.com\";\n" +
            "\t</script>\n" +
            "\t<script type=\"text/javascript\" src=\"https://s.skimresources.com/js/725X1342.skimlinks.js\"></script><script src=\"//stats.wp.com/w.js?47\" type=\"text/javascript\" async defer></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "_tkq = window._tkq || [];\n" +
            "_stq = window._stq || [];\n" +
            "_tkq.push(['storeContext', {'blog_id':'38709636','blog_tz':'0','user_lang':'en','blog_lang':'en','user_id':'0'}]);\n" +
            "_stq.push(['view', {'blog':'38709636','v':'wpcom','tz':'0','user_id':'0','post':'1353','subd':'refactoringfactory'}]);\n" +
            "_stq.push(['extra', {'crypt':'UE5XaGUuOTlwaD85flAmcm1mcmZsaDhkV11YdTdvUG14Q2VDQTR4LlUsLi82dU1mai9BMkEvYVRKb24/czlSRGNXTi1jSU43UmJUZ3VrSS5yT1pHXXlvNnp8QUJVa3h6dHMmTlNaSS1TeklEdlZ5U2ZuJTcyOCtIZHwtNC05d2UmSi8vfkQ/aXIzZVdLMjhHdGlIeG9ZTlQ0djJvVGd4S2I9cE90W058UlFneWpENWw9bzZhKzNfTlhMWDM3dnZUdCVhSmJBbGZsWit0Vk1nZHowOUY9Wm8va2UwX0IsaE9DeEd5LHBbOFhUOFE1UmhDRzFOcn4vR113PyVvd3hQNlJRS0Y5TGt1dEdGaU84dm0xaloreUpWUm1FP1AvRWNjUEs4LnV2Ql81cU94PVU9NEJ0blFEYk1yVHU/P2thT0wscFFfazdy'}]);\n" +
            "_stq.push([ 'clickTrackerInit', '38709636', '1353' ]);\n" +
            "\t</script>\n" +
            "<noscript><img src=\"https://pixel.wp.com/b.gif?v=noscript\" style=\"height:0px;width:0px;overflow:hidden\" alt=\"\" /></noscript>\n" +
            "<script>\n" +
            "if ( 'object' === typeof wpcom_mobile_user_agent_info ) {\n" +
            "\n" +
            "\twpcom_mobile_user_agent_info.init();\n" +
            "\tvar mobileStatsQueryString = \"\";\n" +
            "\t\n" +
            "\tif( false !== wpcom_mobile_user_agent_info.matchedPlatformName )\n" +
            "\t\tmobileStatsQueryString += \"&x_\" + 'mobile_platforms' + '=' + wpcom_mobile_user_agent_info.matchedPlatformName;\n" +
            "\t\n" +
            "\tif( false !== wpcom_mobile_user_agent_info.matchedUserAgentName )\n" +
            "\t\tmobileStatsQueryString += \"&x_\" + 'mobile_devices' + '=' + wpcom_mobile_user_agent_info.matchedUserAgentName;\n" +
            "\t\n" +
            "\tif( wpcom_mobile_user_agent_info.isIPad() )\n" +
            "\t\tmobileStatsQueryString += \"&x_\" + 'ipad_views' + '=' + 'views';\n" +
            "\n" +
            "\tif( \"\" != mobileStatsQueryString ) {\n" +
            "\t\tnew Image().src = document.location.protocol + '//pixel.wp.com/g.gif?v=wpcom-no-pv' + mobileStatsQueryString + '&baba=' + Math.random();\n" +
            "\t}\n" +
            "\t\n" +
            "}\n" +
            "</script>\n" +
            "</body>\n" +
            "</html>\n";

}
