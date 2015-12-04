package com.akkademy;

public class Articles {
     public static String article1 = "<!DOCTYPE html>\n"+
            "<html lang=\"en\">\n"+
            "<head>\n"+
            "<style type=\"text/css\" id=\"syntaxhighlighteranchor\"></style>\n"+
            "</head>\n"+
            "\n"+
            "<body class=\"single single-post postid-1346 single-format-standard logged-in admin-bar no-customize-support mp6 customizer-styles-applied highlander-enabled highlander-light\">\n"+
            "<div id=\"page\" class=\"hfeed site\">\n"+
            "\t<a class=\"skip-link screen-reader-text\" href=\"#content\">Skip to content</a>\n"+
            "\n"+
            "\t<header id=\"masthead\" class=\"site-header\" role=\"banner\">\n"+
            "\n"+
            "\t\t<div class=\"site-branding\">\n"+
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<h1 class=\"site-title\"><a href=\"https://refactoringfactory.wordpress.com/\" rel=\"home\">refactoringFactory(jason.goodwin)</a></h1>\n"+
            "\t\t\t<h2 class=\"site-description\">Eat, sleep, hack and scale. </h2>\n"+
            "\t\t</div>\n"+
            "\n"+
            "\n"+
            "\t\t\t\t\t<button class=\"menu-toggle\" title=\"Sidebar\"><span class=\"screen-reader-text\">Sidebar</span></button>\n"+
            "\t\t\t\t<div class=\"slide-menu\">\n"+
            "\n"+
            "\n"+
            "<div id=\"secondary\" class=\"widget-area clear\" role=\"complementary\">\n"+
            "\t<aside id=\"search-4\" class=\"widget widget_search\"><form role=\"search\" method=\"get\" class=\"search-form\" action=\"https://refactoringfactory.wordpress.com/\">\n"+
            "\t\t\t\t<label>\n"+
            "\t\t\t\t\t<span class=\"screen-reader-text\">Search for:</span>\n"+
            "\t\t\t\t\t<input type=\"search\" class=\"search-field\" placeholder=\"Search &hellip;\" value=\"\" name=\"s\" title=\"Search for:\" />\n"+
            "\t\t\t\t</label>\n"+
            "\t\t\t\t<input type=\"submit\" class=\"search-submit\" value=\"Search\" />\n"+
            "\t\t\t</form></aside><aside id=\"wpcom-goodreads-3\" class=\"widget widget_goodreads\"><h1 class=\"widget-title\">Goodreads</h1><div class=\"gr_custom_widget\" id=\"gr_custom_widget_15850565_read\"></div>\n"+
            "<script src=\"https://www.goodreads.com/review/custom_widget/15850565.Goodreads:%20read?cover_position=&#038;cover_size=small&#038;num_books=5&#038;order=d&#038;shelf=read&#038;sort=date_added&#038;widget_bg_transparent=&#038;widget_id=15850565_read\"></script>\n"+
            "</aside></div><!-- #secondary -->\n"+
            "\n"+
            "\t\t</div>\n"+
            "\t</header><!-- #masthead -->\n"+
            "\n"+
            "\t<div id=\"content\" class=\"site-content\">\n"+
            "\n"+
            "\t<div id=\"primary\" class=\"content-area\">\n"+
            "\t\t<main id=\"main\" class=\"site-main\" role=\"main\">\n"+
            "\n"+
            "\n"+
            "\n"+
            "<article id=\"post-1346\" class=\"post-1346 post type-post status-publish format-standard hentry category-uncategorized\">\n"+
            "\t<header class=\"entry-header\">\n"+
            "\t\t<h1 class=\"entry-title\">Using Emacs Key Bindings in Intellij Successfully on&nbsp;OSX</h1>\n"+
            "\t\t<div class=\"entry-meta\">\n"+
            "\t\t\t<span class=\"posted-on\"><a href=\"https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/\" rel=\"bookmark\"><time class=\"entry-date published\" datetime=\"2015-01-19T04:01:06+00:00\">January 19, 2015</time><time class=\"updated\" datetime=\"2015-01-19T04:02:33+00:00\">January 19, 2015</time></a></span><span class=\"byline\"> <span class=\"author vcard\"><a class=\"url fn n\" href=\"https://refactoringfactory.wordpress.com/author/refactoringfactory/\">refactoringfactory</a></span></span><span class=\"edit-link\"><a class=\"post-edit-link\" href=\"https://wordpress.com/post/refactoringfactory.wordpress.com/1346\">Edit</a></span>\t\t</div><!-- .entry-meta -->\n"+
            "\n"+
            "\t</header><!-- .entry-header -->\n"+
            "\n"+
            "\t<div class=\"entry-content\">\n"+
            "\t\t<p>I&#8217;ve been writing a lot in emacs lately but there is no way in hell I&#8217;d try to write code in statically typed languages without it being heavily backed by an IDE&#8217;s intelli-sense engine.  (eg see: http://martinfowler.com/bliki/PostIntelliJ.html)</p>\n"+
            "<p>Still, I think emacs is a better editor for me personally than the default intelliJ key mappings (which are good and have been improved as of IntelliJ11).</p>\n"+
            "<p>IntelliJ does have good emacs keybinding emulation but it seems busted out of the box on OSX. M-b (backward-word) will print out ∫ instead of moving back a word&#8230; This isn&#8217;t too hard to remedy fortunately. You can generate a new keyboard layout without the unicode characters printed when you&#8217;re holding option. To get it all set up, follow this guide:</p>\n"+
            "<p>1) Go to http://wordherd.com/keyboards/</p>\n"+
            "<p>2) Generate your preferred keyboard layout with these settings. (Here was mine selecting Colemak)</p>\n"+
            "<p><a href=\"https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-02-54-pm.png\"><img class=\"alignnone size-medium wp-image-1347\" src=\"https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-02-54-pm.png?w=300&#038;h=168\" alt=\"Screen Shot 2015-01-18 at 11.02.54 PM\" width=\"300\" height=\"168\" /></a></p>\n"+
            "<p>3) Download the generated .keylayout file.</p>\n"+
            "<p>4) Copy the file to your Keyboard Layouts folder: cp ~/Downloads/My\\ Layout.keylayout ~/Library/Keyboard\\ Layouts/</p>\n"+
            "<p>5) Goto System Preferences -&gt; Language and Region -&gt; Keyboard Preferences</p>\n"+
            "<p>6) Click the + button</p>\n"+
            "<p>7) Select the Others section</p>\n"+
            "<p>8) Choose My Layout</p>\n"+
            "<p><a href=\"https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-05-20-pm.png\"><img class=\"alignnone size-medium wp-image-1349\" src=\"https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-05-20-pm.png?w=300&#038;h=268\" alt=\"Screen Shot 2015-01-18 at 11.05.20 PM\" width=\"300\" height=\"268\" /></a></p>\n"+
            "<p>Done! Your emacs bindings will now work A-OK!</p>\n"+
            "\t\t<div id=\"wordads-preview-parent\" class=\"wpcnt\">\n"+
            "\t\t\t<div class=\"wpa\">\n"+
            "\t\t\t\t<a class=\"wpa-about\" href=\"http://wordpress.com/about-these-ads/\" rel=\"nofollow\">About these ads</a>\n"+
            "\t\t\t\t<div class=\"u\">\n"+
            "\t\t\t\t\t<div class=\"wpa-notice\">\n"+
            "\t\t\t\t\t\t<p>Occasionally, some of your visitors may see an advertisement here.</p>\n"+
            "\t\t\t\t\t\t<p>\n"+
            "\t\t\t\t\t\t\t<a id=\"wordads-preview-more\" href=\"http://wordpress.com/about-these-ads/\" rel=\"nofollow\">Tell me more</a>\n"+
            "\t\t\t\t\t\t\t|\n"+
            "\t\t\t\t\t\t\t<a id=\"wordads-preview-dismiss\" href=\"#\">Dismiss this message</a>\n"+
            "\t\t\t\t\t\t</p>\n"+
            "\t\t\t\t\t</div>\n"+
            "\t\t\t\t</div>\n"+
            "\t\t\t</div>\n"+
            "\t\t</div><div id=\"jp-post-flair\" class=\"sharedaddy sd-like-enabled sd-sharing-enabled\"><div class=\"sharedaddy sd-sharing-enabled\"><div class=\"robots-nocontent sd-block sd-social sd-social-icon-text sd-sharing\"><h3 class=\"sd-title\">Share this:</h3><div class=\"sd-content\"><ul><li class=\"share-press-this\"><a rel=\"nofollow\" data-shared=\"\" class=\"share-press-this sd-button share-icon\" href=\"https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/?share=press-this\" target=\"_blank\" title=\"Click to Press This!\"><span>Press This</span></a></li><li class=\"share-twitter\"><a rel=\"nofollow\" data-shared=\"sharing-twitter-1346\" class=\"share-twitter sd-button share-icon\" href=\"https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/?share=twitter\" target=\"_blank\" title=\"Click to share on Twitter\"><span>Twitter</span></a></li><li class=\"share-facebook\"><a rel=\"nofollow\" data-shared=\"sharing-facebook-1346\" class=\"share-facebook sd-button share-icon\" href=\"https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/?share=facebook\" target=\"_blank\" title=\"Share on Facebook\"><span>Facebook</span></a></li><li class=\"share-end\"></li></ul></div></div></div><div class='sharedaddy sd-block sd-like jetpack-likes-widget-wrapper jetpack-likes-widget-unloaded' id='like-post-wrapper-38709636-1346-565fc08d10116' data-src='//widgets.wp.com/likes/#blog_id=38709636&amp;post_id=1346&amp;origin=refactoringfactory.wordpress.com&amp;obj_id=38709636-1346-565fc08d10116' data-name='like-post-frame-38709636-1346-565fc08d10116'><h3 class='sd-title'>Like this:</h3><div class='likes-widget-placeholder post-likes-widget-placeholder' style='height:55px'><span class='button'><span>Like</span></span> <span class=\"loading\">Loading...</span></div><span class='sd-text-color'></span><a class='sd-link-color'></a></div>\n"+
            "<div id='jp-relatedposts' class='jp-relatedposts' >\n"+
            "\t<h3 class=\"jp-relatedposts-headline\"><em>Related</em></h3>\n"+
            "</div></div>\t\t\t</div><!-- .entry-content -->\n"+
            "\n"+
            "\t<div class=\"entry-format\">\n"+
            "\t\t<a href=\"https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/\"><span class=\"screen-reader-text\">Using Emacs Key Bindings in Intellij Successfully on&nbsp;OSX</span></a>\t</div>\n"+
            "</article><!-- #post-## -->\n"+
            "\n"+
            "\t\t\t\t<nav class=\"navigation post-navigation\" role=\"navigation\">\n"+
            "\t\t<h1 class=\"screen-reader-text\">Post navigation</h1>\n"+
            "\t\t<div class=\"nav-links\">\n"+
            "\t\t\t<div class=\"nav-previous\"><a href=\"https://refactoringfactory.wordpress.com/2015/01/02/basic-git-reference/\" rel=\"prev\"><span class=\"meta-nav\">&larr;</span>&nbsp;Basic Git Reference</a></div><div class=\"nav-next\"><a href=\"https://refactoringfactory.wordpress.com/2015/01/23/how-to-make-an-sbt-project-that-can-run-in-play-or-a-plain-java-project/\" rel=\"next\">How to Make An SBT Project that Can Run In Play or a Plain Java&nbsp;Project&nbsp;<span class=\"meta-nav\">&rarr;</span></a></div>\t\t</div><!-- .nav-links -->\n"+
            "\t</nav><!-- .navigation -->\n"+
            "\n"+
            "\n"+
            "<div id=\"comments\" class=\"comments-area\">\n"+
            "\n"+
            "\n"+
            "\n"+
            "\n"+
            "\t\t\t\t\t<div id=\"respond\" class=\"comment-respond\">\n"+
            "\t\t\t<h3 id=\"reply-title\" class=\"comment-reply-title\">Leave a Reply <small><a rel=\"nofollow\" id=\"cancel-comment-reply-link\" href=\"/2015/01/19/emacsifying-your-intellij-on-osx/#respond\" style=\"display:none;\">Cancel reply</a></small></h3>\t\t\t\t<form action=\"https://refactoringfactory.wordpress.com/wp-comments-post.php\" method=\"post\" id=\"commentform\" class=\"comment-form\" novalidate>\n"+
            "\t\t\t\t\t<input type=\"hidden\" id=\"highlander_comment_nonce\" name=\"highlander_comment_nonce\" value=\"6c3d113679\" /><input type=\"hidden\" name=\"_wp_http_referer\" value=\"/2015/01/19/emacsifying-your-intellij-on-osx/\" />\n"+
            "<input type=\"hidden\" name=\"hc_post_as\" id=\"hc_post_as\" value=\"wordpress\" />\n"+
            "\n"+
            "<div class=\"comment-form-field comment-textarea\">\n"+
            "\t<label for=\"comment\">Enter your comment here...</label>\n"+
            "\t<div id=\"comment-form-comment\"><textarea id=\"comment\" name=\"comment\" title=\"Enter your comment here...\"></textarea></div>\n"+
            "</div>\n"+
            "\n"+
            "<div id=\"comment-form-identity\">\n"+
            "\n"+
            "\t<div id=\"comment-form-nascar\">\n"+
            "\t\t<p>Fill in your details below or click an icon to log in:</p>\n"+
            "\t\t<ul>\n"+
            "\t\t\t<li style=\"display:none;\">\n"+
            "\t\t\t\t<a href=\"#comment-form-guest\" id=\"postas-guest\" title=\"Guest\">\n"+
            "\t\t\t\t\t<span></span>\n"+
            "\t\t\t\t</a>\n"+
            "\t\t\t</li>\n"+
            "\t\t\t<li class=\"selected\">\n"+
            "\t\t\t\t<a href=\"#comment-form-load-service:WordPress.com\" id=\"postas-wordpress\" title=\"WordPress.com\">\n"+
            "\t\t\t\t\t<span></span>\n"+
            "\t\t\t\t</a>\n"+
            "\t\t\t</li>\n"+
            "\t\t\t<li>\n"+
            "\t\t\t\t<a href=\"#comment-form-load-service:Twitter\" id=\"postas-twitter\" title=\"Twitter\">\n"+
            "\t\t\t\t\t<span></span>\n"+
            "\t\t\t\t</a>\n"+
            "\t\t\t</li>\n"+
            "\t\t\t<li>\n"+
            "\t\t\t\t<a href=\"#comment-form-load-service:Facebook\" id=\"postas-facebook\" title=\"Facebook\">\n"+
            "\t\t\t\t\t<span></span>\n"+
            "\t\t\t\t</a>\n"+
            "\t\t\t</li>\n"+
            "\t\t\t<li>\n"+
            "\t\t\t<iframe id=\"googleplus-sign-in\" name=\"googleplus-sign-in\" src=\"https://public-api.wordpress.com/connect/?googleplus-sign-in=https%3A%2F%2Frefactoringfactory.wordpress.com\" width=\"24\" height=\"24\" scrolling=\"no\" allowtransparency=\"true\" seamless=\"seamless\" frameborder=\"0\"></iframe>\n"+
            "\t\t\t</li>\n"+
            "\t\t</ul>\n"+
            "\t</div>\n"+
            "\n"+
            "\t<div id=\"comment-form-guest\" class=\"comment-form-service\">\n"+
            "\t\t<div class=\"comment-form-padder\">\n"+
            "\t\t\t<div class=\"comment-form-avatar\">\n"+
            "<a href=\"https://gravatar.com/site/signup/\" target=\"_blank\">\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Gravatar\" width=\"25\" class=\"no-grav\" />\n"+
            "</a>\t\t\t</div>\n"+
            "\n"+
            "\t\t\t\t<div class=\"comment-form-fields\">\n"+
            "\t\t\t\t<div class=\"comment-form-field comment-form-email\">\n"+
            "\t\t\t\t\t<label for=\"email\">Email <span class=\"required\">(required)</span> <span class=\"nopublish\">(Address never made public)</span></label>\n"+
            "\t\t\t\t\t<div class=\"comment-form-input\"><input id=\"email\" name=\"email\" type=\"email\" value=\"\" /></div>\n"+
            "\t\t\t\t</div>\n"+
            "\t\t\t\t<div class=\"comment-form-field comment-form-author\">\n"+
            "\t\t\t\t\t<label for=\"author\">Name <span class=\"required\">(required)</span></label>\n"+
            "\t\t\t\t\t<div class=\"comment-form-input\"><input id=\"author\" name=\"author\" type=\"text\" value=\"\" /></div>\n"+
            "\t\t\t\t</div>\n"+
            "\t\t\t\t<div class=\"comment-form-field comment-form-url\">\n"+
            "\t\t\t\t\t<label for=\"url\">Website</label>\n"+
            "\t\t\t\t\t<div class=\"comment-form-input\"><input id=\"url\" name=\"url\" type=\"text\" value=\"\" /></div>\n"+
            "\t\t\t\t</div>\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t</div>\n"+
            "\t</div>\n"+
            "\n"+
            "\t<div id=\"comment-form-wordpress\" class=\"comment-form-service selected\">\n"+
            "\t\t<div class=\"comment-form-padder\">\n"+
            "\t\t\t<div class=\"comment-form-avatar\">\n"+
            "\t\t\t\t<img src=\"https://0.gravatar.com/avatar/c2e0b7aaa9705618953d6fd5ecd2f160?s=25&amp;d=https%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D25%26amp%3Bd%3Didenticon%26amp%3Bforcedefault%3Dy%26amp%3Br%3DG&amp;r=G\" alt=\"Gravatar\" width=\"25\" class=\"no-grav\" />\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t\t\t<div class=\"comment-form-fields\">\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"wp_avatar\" id=\"wordpress-avatar\" class=\"comment-meta-wordpress\" value=\"https://0.gravatar.com/avatar/c2e0b7aaa9705618953d6fd5ecd2f160?s=25&#038;d=https%3A%2F%2Fs2.wp.com%2Fwp-content%2Fmu-plugins%2Fhighlander-comments%2Fimages%2Fwplogo.png&#038;r=G\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"wp_user_id\" id=\"wordpress-user_id\" class=\"comment-meta-wordpress\" value=\"38139493\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"wp_access_token\" id=\"wordpress-access_token\" class=\"comment-meta-wordpress\" value=\"6282816adab9d8793a2e7e5582dcf3cd6ce39fc6\" />\n"+
            "\t\t\t\t<p class=\"comment-form-posting-as pa-wordpress\"><strong>refactoringfactory:</strong> You are commenting using your WordPress.com account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'wordpress' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t</div>\n"+
            "\t</div>\n"+
            "\n"+
            "\t<div id=\"comment-form-twitter\" class=\"comment-form-service\">\n"+
            "\t\t<div class=\"comment-form-padder\">\n"+
            "\t\t\t<div class=\"comment-form-avatar\">\n"+
            "\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Twitter picture\" width=\"25\" class=\"no-grav\" />\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t\t\t<div class=\"comment-form-fields\">\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"twitter_avatar\" id=\"twitter-avatar\" class=\"comment-meta-twitter\" value=\"\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"twitter_user_id\" id=\"twitter-user_id\" class=\"comment-meta-twitter\" value=\"\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"twitter_access_token\" id=\"twitter-access_token\" class=\"comment-meta-twitter\" value=\"\" />\n"+
            "\t\t\t\t<p class=\"comment-form-posting-as pa-twitter\"><strong></strong> You are commenting using your Twitter account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'twitter' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t</div>\n"+
            "\t</div>\n"+
            "\n"+
            "\t<div id=\"comment-form-facebook\" class=\"comment-form-service\">\n"+
            "\t\t<div class=\"comment-form-padder\">\n"+
            "\t\t\t<div class=\"comment-form-avatar\">\n"+
            "\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Facebook photo\" width=\"25\" class=\"no-grav\" />\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t\t\t<div class=\"comment-form-fields\">\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"fb_avatar\" id=\"facebook-avatar\" class=\"comment-meta-facebook\" value=\"\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"fb_user_id\" id=\"facebook-user_id\" class=\"comment-meta-facebook\" value=\"\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"fb_access_token\" id=\"facebook-access_token\" class=\"comment-meta-facebook\" value=\"\" />\n"+
            "\t\t\t\t<p class=\"comment-form-posting-as pa-facebook\"><strong></strong> You are commenting using your Facebook account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'facebook' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t</div>\n"+
            "\t</div>\n"+
            "\n"+
            "\t<div id=\"comment-form-googleplus\" class=\"comment-form-service\">\n"+
            "\t\t<div class=\"comment-form-padder\">\n"+
            "\t\t\t<div class=\"comment-form-avatar\">\n"+
            "\t\t\t\t<img src=\"https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G\" alt=\"Google+ photo\" width=\"25\" class=\"no-grav\" />\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t\t\t<div class=\"comment-form-fields\">\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"googleplus_avatar\" id=\"googleplus-avatar\" class=\"comment-meta-googleplus\" value=\"\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"googleplus_user_id\" id=\"googleplus-user_id\" class=\"comment-meta-googleplus\" value=\"\" />\n"+
            "\t\t\t\t<input type=\"hidden\" name=\"googleplus_access_token\" id=\"googleplus-access_token\" class=\"comment-meta-googleplus\" value=\"\" />\n"+
            "\t\t\t\t<p class=\"comment-form-posting-as pa-googleplus\"><strong></strong> You are commenting using your Google+ account. <span class=\"comment-form-log-out\">(&nbsp;<a href=\"javascript:HighlanderComments.doExternalLogout( 'googleplus' );\">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href=\"#\" onclick=\"javascript:HighlanderComments.switchAccount();return false;\">Change</a>&nbsp;)</span></p>\n"+
            "\t\t\t</div>\n"+
            "\n"+
            "\t\t</div>\n"+
            "\t</div>\n"+
            "\n"+
            "\n"+
            "\t<div id=\"comment-form-load-service\" class=\"comment-form-service\">\n"+
            "\t\t<div class=\"comment-form-posting-as-cancel\"><a href=\"javascript:HighlanderComments.cancelExternalWindow();\">Cancel</a></div>\n"+
            "\t\t<p>Connecting to %s</p>\n"+
            "\t</div>\n"+
            "\n"+
            "</div>\n"+
            "\n"+
            "<script type=\"text/javascript\">\n"+
            "var highlander_expando_javascript = function(){\n"+
            "\tvar input = document.createElement( 'input' ),\n"+
            "\t    comment = jQuery( '#comment' );\n"+
            "\n"+
            "\tif ( 'placeholder' in input ) {\n"+
            "\t\tcomment.attr( 'placeholder', jQuery( '.comment-textarea label' ).remove().text() );\n"+
            "\t}\n"+
            "\n"+
            "\t// Expando Mode: start small, then auto-resize on first click + text length\n"+
            "\tjQuery( '#comment-form-identity' ).hide();\n"+
            "\tjQuery( '#comment-form-subscribe' ).hide();\n"+
            "\tjQuery( '#commentform .form-submit' ).hide();\n"+
            "\n"+
            "\tcomment.css( { 'height':'10px' } ).one( 'focus', function() {\n"+
            "\t\tvar timer = setInterval( HighlanderComments.resizeCallback, 10 )\n"+
            "\t\tjQuery( this ).animate( { 'height': HighlanderComments.initialHeight } ).delay( 100 ).queue( function(n) { clearInterval( timer ); HighlanderComments.resizeCallback(); n(); } );\n"+
            "\t\tjQuery( '#comment-form-identity' ).slideDown();\n"+
            "\t\tjQuery( '#comment-form-subscribe' ).slideDown();\n"+
            "\t\tjQuery( '#commentform .form-submit' ).slideDown();\n"+
            "\t});\n"+
            "}\n"+
            "jQuery(document).ready( highlander_expando_javascript );\n"+
            "</script>\n"+
            "\n"+
            "<div id=\"comment-form-subscribe\">\n"+
            "\t<p class=\"comment-subscription-form\"><input type=\"checkbox\" name=\"subscribe\" id=\"subscribe\" value=\"subscribe\" style=\"width: auto;\" tabindex=\"6\"/> <label class=\"subscribe-label\" id=\"subscribe-label\" for=\"subscribe\" style=\"display: inline;\">Notify me of new comments via email.</label></p></div>\n"+
            "\n"+
            "<p class=\"form-submit\"><input name=\"submit\" type=\"submit\" id=\"comment-submit\" class=\"submit\" value=\"Post Comment\" /> <input type='hidden' name='comment_post_ID' value='1346' id='comment_post_ID' />\n"+
            "<input type='hidden' name='comment_parent' id='comment_parent' value='0' />\n"+
            "</p><p style=\"display: none;\"><input type=\"hidden\" id=\"akismet_comment_nonce\" name=\"akismet_comment_nonce\" value=\"a0df4beba5\" /></p>\n"+
            "<input type=\"hidden\" name=\"genseq\" value=\"1449115789\" />\n"+
            "<p style=\"display: none;\"><input type=\"hidden\" id=\"ak_js\" name=\"ak_js\" value=\"139\"/></p>\t\t\t\t</form>\n"+
            "\t\t\t\t\t</div><!-- #respond -->\n"+
            "\t\t<div style=\"clear: both\"></div>\n"+
            "</div><!-- #comments -->\n"+
            "\n"+
            "\n"+
            "\t\t</main><!-- #main -->\n"+
            "\t</div><!-- #primary -->\n"+
            "\n"+
            "\n"+
            "\t</div><!-- #content -->\n"+
            "\n"+
            "\t<footer id=\"colophon\" class=\"site-footer\" role=\"contentinfo\">\n"+
            "\t\t<div class=\"site-info\">\n"+
            "\t\t\t<a href=\"https://wordpress.com/?ref=footer_website\">Create a free website or blog at WordPress.com</a>.\n"+
            "\t\t\t<span class=\"sep\"> | </span>\n"+
            "\t\t\t<a href=\"https://wordpress.com/themes/minnow/\" title=\"Learn more about this theme\">The Minnow Theme</a>.\t\t</div><!-- .site-info -->\n"+
            "\t</footer><!-- #colophon -->\n"+
            "</div><!-- #page -->\n"+
            "\n"+
            "<!-- wpcom_wp_footer -->\n"+
            "\t<script type=\"text/javascript\">\n"+
            "\t/* <![CDATA[ */\n"+
            "\t\tjQuery(document).ready( function($) {\n"+
            "\t\t\tfunction doFollowingHover() {\n"+
            "\t\t\t\t$('#wp-admin-bar-follow > a').unbind( '.unfollow' );\n"+
            "\n"+
            "\t\t\t\t$('#wp-admin-bar-follow > a').bind( 'mouseover.unfollow', function() {\n"+
            "\n"+
            "\t\t\t\t\t$(this).html( \"Unfollow\" ).parent( 'li' ).addClass( 'unfollow' );\n"+
            "\t\t\t\t});\n"+
            "\t\t\t\t$('#wp-admin-bar-follow > a').bind( 'mouseout.unfollow', function() {\n"+
            "\t\t\t\t\t$(this).html( \"Following\" ).parent( 'li' ).removeClass( 'unfollow' );\n"+
            "\t\t\t\t});\n"+
            "\t\t\t}\n"+
            "\n"+
            "\t\t\t$('#wp-admin-bar-follow > a').click( function( e ) {\n"+
            "\t\t\t\t$('#wp-admin-bar-follow > a').unbind( '.unfollow' );\n"+
            "\n"+
            "\t\t\t\te.preventDefault();\n"+
            "\n"+
            "\t\t\t\tvar link = $( this ), li = $( '#wp-admin-bar-follow' ), timeout = 0;\n"+
            "\n"+
            "\t\t\t\tif ( li.hasClass( 'subscribed' ) ) {\n"+
            "\t\t\t\t\tli.removeClass( 'subscribed' ).removeClass( 'unfollow' );\n"+
            "\t\t\t\t\tlink.html( \"Follow\" );\n"+
            "\n"+
            "\t\t\t\t\t$('body').append( $( 'div.wpcom-bubble' ).removeClass( 'fadein' ) ).off( 'click.bubble' );\n"+
            "\n"+
            "\t\t\t\t\tvar action = 'ab_unsubscribe_from_blog';\n"+
            "\t\t\t\t} else {\n"+
            "\t\t\t\t\tli.addClass( 'subscribed' ).removeClass( 'unfollow' );\n"+
            "\t\t\t\t\tlink.html( \"Following\" );\n"+
            "\n"+
            "\t\t\t\t\t\tvar left = 131 - link.width();\n"+
            "\t\t\t\t\t\tli.append( $( 'div.wpcom-bubble' ).css( { left: '-' + left + 'px' } ) );\n"+
            "\t\t\t\t\t\t$( 'div.bubble-txt', 'div.wpcom-bubble' ).html( \"New posts from this blog will now appear in <a target=\\\"_blank\\\" href=\\\"http:\\/\\/wordpress.com\\/\\\">your reader<\\/a>. You can manage email alerts from your <a target=\\\"_blank\\\" href=\\\"http:\\/\\/wordpress.com\\/following\\/edit\\/\\\">subscriptions page<\\/a>.\" );\n"+
            "\n"+
            "\t\t\t\t\t\t$( 'div.wpcom-bubble.action-bubble' ).addClass( 'fadein' );\n"+
            "\n"+
            "\t\t\t\t\t\tsetTimeout( function() {\n"+
            "\t\t\t\t\t\t\t$('body').on( 'click.bubble touchstart.bubble', function(e) {\n"+
            "\t\t\t\t\t\t\t\tif ( !$(e.target).hasClass('wpcom-bubble') && !$(e.target).parents( 'div.wpcom-bubble' ).length )\n"+
            "\t\t\t\t\t\t\t\t\thideBubble();\n"+
            "\t\t\t\t\t\t\t});\n"+
            "\t\t\t\t\t\t\tsetTimeout( hideBubble, 15000 );\n"+
            "\t\t\t\t\t\t}, 500 );\n"+
            "\n"+
            "\t\t\t\t\tvar action = 'ab_subscribe_to_blog';\n"+
            "\t\t\t\t\t$('#wp-admin-bar-follow > a').bind( 'mouseout.shift', function() {\n"+
            "\t\t\t\t\t\tdoFollowingHover();\n"+
            "\t\t\t\t\t\t$(this).unbind( '.shift' );\n"+
            "\t\t\t\t\t});\n"+
            "\t\t\t\t}\n"+
            "\n"+
            "\t\t\t\tvar nonce = link.attr( 'href' ).split( '_wpnonce=' );\n"+
            "\t\t\t\tnonce = nonce[1];\n"+
            "\n"+
            "\t\t\t\t$.post( \"https:\\/\\/refactoringfactory.wordpress.com\\/wp-admin\\/admin-ajax.php\", {\n"+
            "\t\t\t\t\t'action': action,\n"+
            "\t\t\t\t\t'_wpnonce': nonce,\n"+
            "\t\t\t\t\t'source': 'admin_bar',\n"+
            "\t\t\t\t\t'blog_id': 38709636\t\t\t\t});\n"+
            "\t\t\t});\n"+
            "\t\t});\n"+
            "\t/* ]]> */\n"+
            "\t</script>\n"+
            "</body>\n"+
            "</html>\n";
}
