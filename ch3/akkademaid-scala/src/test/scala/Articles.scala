
object Articles {
  val article1 = """<!DOCTYPE html>
                   |<html lang="en">
                   |<head>
                          |<style type="text/css" id="syntaxhighlighteranchor"></style>
                   |</head>
                   |
                   |<body class="single single-post postid-1346 single-format-standard logged-in admin-bar no-customize-support mp6 customizer-styles-applied highlander-enabled highlander-light">
                   |<div id="page" class="hfeed site">
                   |	<a class="skip-link screen-reader-text" href="#content">Skip to content</a>
                   |
                   |	<header id="masthead" class="site-header" role="banner">
                   |
                   |		<div class="site-branding">
                   |													<h1 class="site-title"><a href="https://refactoringfactory.wordpress.com/" rel="home">refactoringFactory(jason.goodwin)</a></h1>
                   |			<h2 class="site-description">Eat, sleep, hack and scale. </h2>
                   |		</div>
                   |
                   |
                   |					<button class="menu-toggle" title="Sidebar"><span class="screen-reader-text">Sidebar</span></button>
                   |				<div class="slide-menu">
                   |
                   |
                   |<div id="secondary" class="widget-area clear" role="complementary">
                   |	<aside id="search-4" class="widget widget_search"><form role="search" method="get" class="search-form" action="https://refactoringfactory.wordpress.com/">
                   |				<label>
                   |					<span class="screen-reader-text">Search for:</span>
                   |					<input type="search" class="search-field" placeholder="Search &hellip;" value="" name="s" title="Search for:" />
                   |				</label>
                   |				<input type="submit" class="search-submit" value="Search" />
                   |			</form></aside><aside id="wpcom-goodreads-3" class="widget widget_goodreads"><h1 class="widget-title">Goodreads</h1><div class="gr_custom_widget" id="gr_custom_widget_15850565_read"></div>
                   |<script src="https://www.goodreads.com/review/custom_widget/15850565.Goodreads:%20read?cover_position=&#038;cover_size=small&#038;num_books=5&#038;order=d&#038;shelf=read&#038;sort=date_added&#038;widget_bg_transparent=&#038;widget_id=15850565_read"></script>
                   |</aside></div><!-- #secondary -->
                   |
                   |		</div>
                   |	</header><!-- #masthead -->
                   |
                   |	<div id="content" class="site-content">
                   |
                   |	<div id="primary" class="content-area">
                   |		<main id="main" class="site-main" role="main">
                   |
                   |
                   |
                   |<article id="post-1346" class="post-1346 post type-post status-publish format-standard hentry category-uncategorized">
                   |	<header class="entry-header">
                   |		<h1 class="entry-title">Using Emacs Key Bindings in Intellij Successfully on&nbsp;OSX</h1>
                   |		<div class="entry-meta">
                   |			<span class="posted-on"><a href="https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/" rel="bookmark"><time class="entry-date published" datetime="2015-01-19T04:01:06+00:00">January 19, 2015</time><time class="updated" datetime="2015-01-19T04:02:33+00:00">January 19, 2015</time></a></span><span class="byline"> <span class="author vcard"><a class="url fn n" href="https://refactoringfactory.wordpress.com/author/refactoringfactory/">refactoringfactory</a></span></span><span class="edit-link"><a class="post-edit-link" href="https://wordpress.com/post/refactoringfactory.wordpress.com/1346">Edit</a></span>		</div><!-- .entry-meta -->
                   |
                   |	</header><!-- .entry-header -->
                   |
                   |	<div class="entry-content">
                   |		<p>I&#8217;ve been writing a lot in emacs lately but there is no way in hell I&#8217;d try to write code in statically typed languages without it being heavily backed by an IDE&#8217;s intelli-sense engine.  (eg see: http://martinfowler.com/bliki/PostIntelliJ.html)</p>
                   |<p>Still, I think emacs is a better editor for me personally than the default intelliJ key mappings (which are good and have been improved as of IntelliJ11).</p>
                   |<p>IntelliJ does have good emacs keybinding emulation but it seems busted out of the box on OSX. M-b (backward-word) will print out ∫ instead of moving back a word&#8230; This isn&#8217;t too hard to remedy fortunately. You can generate a new keyboard layout without the unicode characters printed when you&#8217;re holding option. To get it all set up, follow this guide:</p>
                   |<p>1) Go to http://wordherd.com/keyboards/</p>
                   |<p>2) Generate your preferred keyboard layout with these settings. (Here was mine selecting Colemak)</p>
                   |<p><a href="https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-02-54-pm.png"><img class="alignnone size-medium wp-image-1347" src="https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-02-54-pm.png?w=300&#038;h=168" alt="Screen Shot 2015-01-18 at 11.02.54 PM" width="300" height="168" /></a></p>
                   |<p>3) Download the generated .keylayout file.</p>
                   |<p>4) Copy the file to your Keyboard Layouts folder: cp ~/Downloads/My\ Layout.keylayout ~/Library/Keyboard\ Layouts/</p>
                   |<p>5) Goto System Preferences -&gt; Language and Region -&gt; Keyboard Preferences</p>
                   |<p>6) Click the + button</p>
                   |<p>7) Select the Others section</p>
                   |<p>8) Choose My Layout</p>
                   |<p><a href="https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-05-20-pm.png"><img class="alignnone size-medium wp-image-1349" src="https://refactoringfactory.files.wordpress.com/2015/01/screen-shot-2015-01-18-at-11-05-20-pm.png?w=300&#038;h=268" alt="Screen Shot 2015-01-18 at 11.05.20 PM" width="300" height="268" /></a></p>
                   |<p>Done! Your emacs bindings will now work A-OK!</p>
                   |		<div id="wordads-preview-parent" class="wpcnt">
                   |			<div class="wpa">
                   |				<a class="wpa-about" href="http://wordpress.com/about-these-ads/" rel="nofollow">About these ads</a>
                   |				<div class="u">
                   |					<div class="wpa-notice">
                   |						<p>Occasionally, some of your visitors may see an advertisement here.</p>
                   |						<p>
                   |							<a id="wordads-preview-more" href="http://wordpress.com/about-these-ads/" rel="nofollow">Tell me more</a>
                   |							|
                   |							<a id="wordads-preview-dismiss" href="#">Dismiss this message</a>
                   |						</p>
                   |					</div>
                   |				</div>
                   |			</div>
                   |		</div><div id="jp-post-flair" class="sharedaddy sd-like-enabled sd-sharing-enabled"><div class="sharedaddy sd-sharing-enabled"><div class="robots-nocontent sd-block sd-social sd-social-icon-text sd-sharing"><h3 class="sd-title">Share this:</h3><div class="sd-content"><ul><li class="share-press-this"><a rel="nofollow" data-shared="" class="share-press-this sd-button share-icon" href="https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/?share=press-this" target="_blank" title="Click to Press This!"><span>Press This</span></a></li><li class="share-twitter"><a rel="nofollow" data-shared="sharing-twitter-1346" class="share-twitter sd-button share-icon" href="https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/?share=twitter" target="_blank" title="Click to share on Twitter"><span>Twitter</span></a></li><li class="share-facebook"><a rel="nofollow" data-shared="sharing-facebook-1346" class="share-facebook sd-button share-icon" href="https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/?share=facebook" target="_blank" title="Share on Facebook"><span>Facebook</span></a></li><li class="share-end"></li></ul></div></div></div><div class='sharedaddy sd-block sd-like jetpack-likes-widget-wrapper jetpack-likes-widget-unloaded' id='like-post-wrapper-38709636-1346-565fc08d10116' data-src='//widgets.wp.com/likes/#blog_id=38709636&amp;post_id=1346&amp;origin=refactoringfactory.wordpress.com&amp;obj_id=38709636-1346-565fc08d10116' data-name='like-post-frame-38709636-1346-565fc08d10116'><h3 class='sd-title'>Like this:</h3><div class='likes-widget-placeholder post-likes-widget-placeholder' style='height:55px'><span class='button'><span>Like</span></span> <span class="loading">Loading...</span></div><span class='sd-text-color'></span><a class='sd-link-color'></a></div>
                   |<div id='jp-relatedposts' class='jp-relatedposts' >
                   |	<h3 class="jp-relatedposts-headline"><em>Related</em></h3>
                   |</div></div>			</div><!-- .entry-content -->
                   |
                   |	<div class="entry-format">
                   |		<a href="https://refactoringfactory.wordpress.com/2015/01/19/emacsifying-your-intellij-on-osx/"><span class="screen-reader-text">Using Emacs Key Bindings in Intellij Successfully on&nbsp;OSX</span></a>	</div>
                   |</article><!-- #post-## -->
                   |
                   |				<nav class="navigation post-navigation" role="navigation">
                   |		<h1 class="screen-reader-text">Post navigation</h1>
                   |		<div class="nav-links">
                   |			<div class="nav-previous"><a href="https://refactoringfactory.wordpress.com/2015/01/02/basic-git-reference/" rel="prev"><span class="meta-nav">&larr;</span>&nbsp;Basic Git Reference</a></div><div class="nav-next"><a href="https://refactoringfactory.wordpress.com/2015/01/23/how-to-make-an-sbt-project-that-can-run-in-play-or-a-plain-java-project/" rel="next">How to Make An SBT Project that Can Run In Play or a Plain Java&nbsp;Project&nbsp;<span class="meta-nav">&rarr;</span></a></div>		</div><!-- .nav-links -->
                   |	</nav><!-- .navigation -->
                   |
                   |
                   |<div id="comments" class="comments-area">
                   |
                   |
                   |
                   |
                   |					<div id="respond" class="comment-respond">
                   |			<h3 id="reply-title" class="comment-reply-title">Leave a Reply <small><a rel="nofollow" id="cancel-comment-reply-link" href="/2015/01/19/emacsifying-your-intellij-on-osx/#respond" style="display:none;">Cancel reply</a></small></h3>				<form action="https://refactoringfactory.wordpress.com/wp-comments-post.php" method="post" id="commentform" class="comment-form" novalidate>
                   |					<input type="hidden" id="highlander_comment_nonce" name="highlander_comment_nonce" value="6c3d113679" /><input type="hidden" name="_wp_http_referer" value="/2015/01/19/emacsifying-your-intellij-on-osx/" />
                   |<input type="hidden" name="hc_post_as" id="hc_post_as" value="wordpress" />
                   |
                   |<div class="comment-form-field comment-textarea">
                   |	<label for="comment">Enter your comment here...</label>
                   |	<div id="comment-form-comment"><textarea id="comment" name="comment" title="Enter your comment here..."></textarea></div>
                   |</div>
                   |
                   |<div id="comment-form-identity">
                   |
                   |	<div id="comment-form-nascar">
                   |		<p>Fill in your details below or click an icon to log in:</p>
                   |		<ul>
                   |			<li style="display:none;">
                   |				<a href="#comment-form-guest" id="postas-guest" title="Guest">
                   |					<span></span>
                   |				</a>
                   |			</li>
                   |			<li class="selected">
                   |				<a href="#comment-form-load-service:WordPress.com" id="postas-wordpress" title="WordPress.com">
                   |					<span></span>
                   |				</a>
                   |			</li>
                   |			<li>
                   |				<a href="#comment-form-load-service:Twitter" id="postas-twitter" title="Twitter">
                   |					<span></span>
                   |				</a>
                   |			</li>
                   |			<li>
                   |				<a href="#comment-form-load-service:Facebook" id="postas-facebook" title="Facebook">
                   |					<span></span>
                   |				</a>
                   |			</li>
                   |			<li>
                   |			<iframe id="googleplus-sign-in" name="googleplus-sign-in" src="https://public-api.wordpress.com/connect/?googleplus-sign-in=https%3A%2F%2Frefactoringfactory.wordpress.com" width="24" height="24" scrolling="no" allowtransparency="true" seamless="seamless" frameborder="0"></iframe>
                   |			</li>
                   |		</ul>
                   |	</div>
                   |
                   |	<div id="comment-form-guest" class="comment-form-service">
                   |		<div class="comment-form-padder">
                   |			<div class="comment-form-avatar">
                   |<a href="https://gravatar.com/site/signup/" target="_blank">				<img src="https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G" alt="Gravatar" width="25" class="no-grav" />
                   |</a>			</div>
                   |
                   |				<div class="comment-form-fields">
                   |				<div class="comment-form-field comment-form-email">
                   |					<label for="email">Email <span class="required">(required)</span> <span class="nopublish">(Address never made public)</span></label>
                   |					<div class="comment-form-input"><input id="email" name="email" type="email" value="" /></div>
                   |				</div>
                   |				<div class="comment-form-field comment-form-author">
                   |					<label for="author">Name <span class="required">(required)</span></label>
                   |					<div class="comment-form-input"><input id="author" name="author" type="text" value="" /></div>
                   |				</div>
                   |				<div class="comment-form-field comment-form-url">
                   |					<label for="url">Website</label>
                   |					<div class="comment-form-input"><input id="url" name="url" type="text" value="" /></div>
                   |				</div>
                   |			</div>
                   |
                   |		</div>
                   |	</div>
                   |
                   |	<div id="comment-form-wordpress" class="comment-form-service selected">
                   |		<div class="comment-form-padder">
                   |			<div class="comment-form-avatar">
                   |				<img src="https://0.gravatar.com/avatar/c2e0b7aaa9705618953d6fd5ecd2f160?s=25&amp;d=https%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D25%26amp%3Bd%3Didenticon%26amp%3Bforcedefault%3Dy%26amp%3Br%3DG&amp;r=G" alt="Gravatar" width="25" class="no-grav" />
                   |			</div>
                   |
                   |				<div class="comment-form-fields">
                   |				<input type="hidden" name="wp_avatar" id="wordpress-avatar" class="comment-meta-wordpress" value="https://0.gravatar.com/avatar/c2e0b7aaa9705618953d6fd5ecd2f160?s=25&#038;d=https%3A%2F%2Fs2.wp.com%2Fwp-content%2Fmu-plugins%2Fhighlander-comments%2Fimages%2Fwplogo.png&#038;r=G" />
                   |				<input type="hidden" name="wp_user_id" id="wordpress-user_id" class="comment-meta-wordpress" value="38139493" />
                   |				<input type="hidden" name="wp_access_token" id="wordpress-access_token" class="comment-meta-wordpress" value="6282816adab9d8793a2e7e5582dcf3cd6ce39fc6" />
                   |				<p class="comment-form-posting-as pa-wordpress"><strong>refactoringfactory:</strong> You are commenting using your WordPress.com account. <span class="comment-form-log-out">(&nbsp;<a href="javascript:HighlanderComments.doExternalLogout( 'wordpress' );">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href="#" onclick="javascript:HighlanderComments.switchAccount();return false;">Change</a>&nbsp;)</span></p>
                   |			</div>
                   |
                   |		</div>
                   |	</div>
                   |
                   |	<div id="comment-form-twitter" class="comment-form-service">
                   |		<div class="comment-form-padder">
                   |			<div class="comment-form-avatar">
                   |				<img src="https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G" alt="Twitter picture" width="25" class="no-grav" />
                   |			</div>
                   |
                   |				<div class="comment-form-fields">
                   |				<input type="hidden" name="twitter_avatar" id="twitter-avatar" class="comment-meta-twitter" value="" />
                   |				<input type="hidden" name="twitter_user_id" id="twitter-user_id" class="comment-meta-twitter" value="" />
                   |				<input type="hidden" name="twitter_access_token" id="twitter-access_token" class="comment-meta-twitter" value="" />
                   |				<p class="comment-form-posting-as pa-twitter"><strong></strong> You are commenting using your Twitter account. <span class="comment-form-log-out">(&nbsp;<a href="javascript:HighlanderComments.doExternalLogout( 'twitter' );">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href="#" onclick="javascript:HighlanderComments.switchAccount();return false;">Change</a>&nbsp;)</span></p>
                   |			</div>
                   |
                   |		</div>
                   |	</div>
                   |
                   |	<div id="comment-form-facebook" class="comment-form-service">
                   |		<div class="comment-form-padder">
                   |			<div class="comment-form-avatar">
                   |				<img src="https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G" alt="Facebook photo" width="25" class="no-grav" />
                   |			</div>
                   |
                   |				<div class="comment-form-fields">
                   |				<input type="hidden" name="fb_avatar" id="facebook-avatar" class="comment-meta-facebook" value="" />
                   |				<input type="hidden" name="fb_user_id" id="facebook-user_id" class="comment-meta-facebook" value="" />
                   |				<input type="hidden" name="fb_access_token" id="facebook-access_token" class="comment-meta-facebook" value="" />
                   |				<p class="comment-form-posting-as pa-facebook"><strong></strong> You are commenting using your Facebook account. <span class="comment-form-log-out">(&nbsp;<a href="javascript:HighlanderComments.doExternalLogout( 'facebook' );">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href="#" onclick="javascript:HighlanderComments.switchAccount();return false;">Change</a>&nbsp;)</span></p>
                   |			</div>
                   |
                   |		</div>
                   |	</div>
                   |
                   |	<div id="comment-form-googleplus" class="comment-form-service">
                   |		<div class="comment-form-padder">
                   |			<div class="comment-form-avatar">
                   |				<img src="https://1.gravatar.com/avatar/ad516503a11cd5ca435acc9bb6523536?s=25&amp;d=identicon&amp;forcedefault=y&amp;r=G" alt="Google+ photo" width="25" class="no-grav" />
                   |			</div>
                   |
                   |				<div class="comment-form-fields">
                   |				<input type="hidden" name="googleplus_avatar" id="googleplus-avatar" class="comment-meta-googleplus" value="" />
                   |				<input type="hidden" name="googleplus_user_id" id="googleplus-user_id" class="comment-meta-googleplus" value="" />
                   |				<input type="hidden" name="googleplus_access_token" id="googleplus-access_token" class="comment-meta-googleplus" value="" />
                   |				<p class="comment-form-posting-as pa-googleplus"><strong></strong> You are commenting using your Google+ account. <span class="comment-form-log-out">(&nbsp;<a href="javascript:HighlanderComments.doExternalLogout( 'googleplus' );">Log&nbsp;Out</a>&nbsp;/&nbsp;<a href="#" onclick="javascript:HighlanderComments.switchAccount();return false;">Change</a>&nbsp;)</span></p>
                   |			</div>
                   |
                   |		</div>
                   |	</div>
                   |
                   |
                   |	<div id="comment-form-load-service" class="comment-form-service">
                   |		<div class="comment-form-posting-as-cancel"><a href="javascript:HighlanderComments.cancelExternalWindow();">Cancel</a></div>
                   |		<p>Connecting to %s</p>
                   |	</div>
                   |
                   |</div>
                   |
                   |<script type="text/javascript">
                   |var highlander_expando_javascript = function(){
                   |	var input = document.createElement( 'input' ),
                   |	    comment = jQuery( '#comment' );
                   |
                   |	if ( 'placeholder' in input ) {
                   |		comment.attr( 'placeholder', jQuery( '.comment-textarea label' ).remove().text() );
                   |	}
                   |
                   |	// Expando Mode: start small, then auto-resize on first click + text length
                   |	jQuery( '#comment-form-identity' ).hide();
                   |	jQuery( '#comment-form-subscribe' ).hide();
                   |	jQuery( '#commentform .form-submit' ).hide();
                   |
                   |	comment.css( { 'height':'10px' } ).one( 'focus', function() {
                   |		var timer = setInterval( HighlanderComments.resizeCallback, 10 )
                   |		jQuery( this ).animate( { 'height': HighlanderComments.initialHeight } ).delay( 100 ).queue( function(n) { clearInterval( timer ); HighlanderComments.resizeCallback(); n(); } );
                   |		jQuery( '#comment-form-identity' ).slideDown();
                   |		jQuery( '#comment-form-subscribe' ).slideDown();
                   |		jQuery( '#commentform .form-submit' ).slideDown();
                   |	});
                   |}
                   |jQuery(document).ready( highlander_expando_javascript );
                   |</script>
                   |
                   |<div id="comment-form-subscribe">
                   |	<p class="comment-subscription-form"><input type="checkbox" name="subscribe" id="subscribe" value="subscribe" style="width: auto;" tabindex="6"/> <label class="subscribe-label" id="subscribe-label" for="subscribe" style="display: inline;">Notify me of new comments via email.</label></p></div>
                   |
                   |<p class="form-submit"><input name="submit" type="submit" id="comment-submit" class="submit" value="Post Comment" /> <input type='hidden' name='comment_post_ID' value='1346' id='comment_post_ID' />
                   |<input type='hidden' name='comment_parent' id='comment_parent' value='0' />
                   |</p><p style="display: none;"><input type="hidden" id="akismet_comment_nonce" name="akismet_comment_nonce" value="a0df4beba5" /></p>
                   |<input type="hidden" name="genseq" value="1449115789" />
                   |<p style="display: none;"><input type="hidden" id="ak_js" name="ak_js" value="139"/></p>				</form>
                   |					</div><!-- #respond -->
                   |		<div style="clear: both"></div>
                   |</div><!-- #comments -->
                   |
                   |
                   |		</main><!-- #main -->
                   |	</div><!-- #primary -->
                   |
                   |
                   |	</div><!-- #content -->
                   |
                   |	<footer id="colophon" class="site-footer" role="contentinfo">
                   |		<div class="site-info">
                   |			<a href="https://wordpress.com/?ref=footer_website">Create a free website or blog at WordPress.com</a>.
                   |			<span class="sep"> | </span>
                   |			<a href="https://wordpress.com/themes/minnow/" title="Learn more about this theme">The Minnow Theme</a>.		</div><!-- .site-info -->
                   |	</footer><!-- #colophon -->
                   |</div><!-- #page -->
                   |
                   |<!-- wpcom_wp_footer -->
                   |	<script type="text/javascript">
                   |	/* <![CDATA[ */
                   |		jQuery(document).ready( function($) {
                   |			function doFollowingHover() {
                   |				$('#wp-admin-bar-follow > a').unbind( '.unfollow' );
                   |
                   |				$('#wp-admin-bar-follow > a').bind( 'mouseover.unfollow', function() {
                   |
                   |					$(this).html( "Unfollow" ).parent( 'li' ).addClass( 'unfollow' );
                   |				});
                   |				$('#wp-admin-bar-follow > a').bind( 'mouseout.unfollow', function() {
                   |					$(this).html( "Following" ).parent( 'li' ).removeClass( 'unfollow' );
                   |				});
                   |			}
                   |
                   |			$('#wp-admin-bar-follow > a').click( function( e ) {
                   |				$('#wp-admin-bar-follow > a').unbind( '.unfollow' );
                   |
                   |				e.preventDefault();
                   |
                   |				var link = $( this ), li = $( '#wp-admin-bar-follow' ), timeout = 0;
                   |
                   |				if ( li.hasClass( 'subscribed' ) ) {
                   |					li.removeClass( 'subscribed' ).removeClass( 'unfollow' );
                   |					link.html( "Follow" );
                   |
                   |					$('body').append( $( 'div.wpcom-bubble' ).removeClass( 'fadein' ) ).off( 'click.bubble' );
                   |
                   |					var action = 'ab_unsubscribe_from_blog';
                   |				} else {
                   |					li.addClass( 'subscribed' ).removeClass( 'unfollow' );
                   |					link.html( "Following" );
                   |
                   |						var left = 131 - link.width();
                   |						li.append( $( 'div.wpcom-bubble' ).css( { left: '-' + left + 'px' } ) );
                   |						$( 'div.bubble-txt', 'div.wpcom-bubble' ).html( "New posts from this blog will now appear in <a target=\"_blank\" href=\"http:\/\/wordpress.com\/\">your reader<\/a>. You can manage email alerts from your <a target=\"_blank\" href=\"http:\/\/wordpress.com\/following\/edit\/\">subscriptions page<\/a>." );
                   |
                   |						$( 'div.wpcom-bubble.action-bubble' ).addClass( 'fadein' );
                   |
                   |						setTimeout( function() {
                   |							$('body').on( 'click.bubble touchstart.bubble', function(e) {
                   |								if ( !$(e.target).hasClass('wpcom-bubble') && !$(e.target).parents( 'div.wpcom-bubble' ).length )
                   |									hideBubble();
                   |							});
                   |							setTimeout( hideBubble, 15000 );
                   |						}, 500 );
                   |
                   |					var action = 'ab_subscribe_to_blog';
                   |					$('#wp-admin-bar-follow > a').bind( 'mouseout.shift', function() {
                   |						doFollowingHover();
                   |						$(this).unbind( '.shift' );
                   |					});
                   |				}
                   |
                   |				var nonce = link.attr( 'href' ).split( '_wpnonce=' );
                   |				nonce = nonce[1];
                   |
                   |				$.post( "https:\/\/refactoringfactory.wordpress.com\/wp-admin\/admin-ajax.php", {
                   |					'action': action,
                   |					'_wpnonce': nonce,
                   |					'source': 'admin_bar',
                   |					'blog_id': 38709636				});
                   |			});
                   |		});
                   |	/* ]]> */
                   |	</script>
                   |</body>
                   |</html>
                   |""".stripMargin
}
