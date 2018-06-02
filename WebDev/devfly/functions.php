<?php
/**
 * main_multi_theme(davfly1) functions and definitions
 *
 * @link https://developer.wordpress.org/themes/basics/theme-functions/
 *
 * @package devfly
 */

if ( ! function_exists( 'main_multi_themedavfly1_setup' ) ) :
/**
 * Sets up theme defaults and registers support for various WordPress features.
 *
 * Note that this function is hooked into the after_setup_theme hook, which
 * runs before the init hook. The init hook is too late for some features, such
 * as indicating support for post thumbnails.
 */
function main_multi_themedavfly1_setup() {
	/*
	 * Make theme available for translation.
	 * Translations can be filed in the /languages/ directory.
	 * If you're building a theme based on main_multi_theme(davfly1), use a find and replace
	 * to change 'devfly' to the name of your theme in all the template files.
	 */
	load_theme_textdomain( 'devfly', get_template_directory() . '/languages' );

	// Add default posts and comments RSS feed links to head.
	add_theme_support( 'automatic-feed-links' );

	/*
	 * Let WordPress manage the document title.
	 * By adding theme support, we declare that this theme does not use a
	 * hard-coded <title> tag in the document head, and expect WordPress to
	 * provide it for us.
	 */
	add_theme_support( 'title-tag' );

	/*
	 * Enable support for Post Thumbnails on posts and pages.
	 *
	 * @link https://developer.wordpress.org/themes/functionality/featured-images-post-thumbnails/
	 */
	add_theme_support( 'post-thumbnails' );

	// This theme uses wp_nav_menu() in one location.
	register_nav_menus( array(
		'menu-1' => esc_html__( 'Primary', 'devfly' ),
	) );

	/*
	 * Switch default core markup for search form, comment form, and comments
	 * to output valid HTML5.
	 */
	add_theme_support( 'html5', array(
		'search-form',
		'comment-form',
		'comment-list',
		'gallery',
		'caption',
	) );
	/*
   * Admin functionality
   */
  if( is_admin() ) {

    /**
     * Add styles to post editor (editor-style.css)
     */
    add_editor_style('css/custom-editor-style.css');
  }
	// Set up the WordPress core custom background feature.
	add_theme_support( 'custom-background', apply_filters( 'main_multi_themedavfly1_custom_background_args', array(
		'default-color' => 'ffffff',
		'default-image' => '',
	) ) );

	// Add theme support for selective refresh for widgets.
	add_theme_support( 'customize-selective-refresh-widgets' );
}
endif;
add_action( 'after_setup_theme', 'main_multi_themedavfly1_setup' );

/**
 * Set the content width in pixels, based on the theme's design and stylesheet.
 *
 * Priority 0 to make it available to lower priority callbacks.
 *
 * @global int $content_width
 */
function main_multi_themedavfly1_content_width() {
	$GLOBALS['content_width'] = apply_filters( 'main_multi_themedavfly1_content_width', 640 );
}
add_action( 'after_setup_theme', 'main_multi_themedavfly1_content_width', 0 );

/**
 * Register widget area.
 *
 * @link https://developer.wordpress.org/themes/functionality/sidebars/#registering-a-sidebar
 */
function main_multi_themedavfly1_widgets_init() {
	register_sidebar( array(
		'name'          => esc_html__( 'Sidebar', 'devfly' ),
		'id'            => 'sidebar-1',
		'description'   => esc_html__( 'Add widgets here.', 'devfly' ),
		'before_widget' => '<section id="%1$s" class="widget %2$s">',
		'after_widget'  => '</section>',
		'before_title'  => '<h4>',
		'after_title'   => '</h4>',
	) );
	 register_sidebar( array(
		'name'          => esc_html__( 'Footer widgets 1', 'devfly' ),
		'id'            => 'sidebar-footer1',
		'description'   => esc_html__( 'Add widgets here.', 'devfly' ),
		'before_widget' => '<section id="%1$s" class="widget %2$s">',
		'after_widget'  => '</section>',
		'before_title'  => '<h4>',
		'after_title'   => '</h4>',
        
	) );
    register_sidebar( array(
		'name'          => esc_html__( 'Footer widgets 2', 'devfly' ),
		'id'            => 'sidebar-footer2',
		'description'   => esc_html__( 'Add widgets here.', 'devfly' ),
		'before_widget' => '<section id="%1$s" class="widget %2$s">',
		'after_widget'  => '</section>',
		'before_title'  => '<h4>',
		'after_title'   => '</h4>',
	) );
    
     register_sidebar( array(
		'name'          => esc_html__( 'Footer widgets 3', 'devfly' ),
		'id'            => 'sidebar-footer3',
		'description'   => esc_html__( 'Add widgets here.', 'devfly' ),
		'before_widget' => '<section id="%1$s" class="widget %2$s">',
		'after_widget'  => '</section>',
		'before_title'  => '<h4>',
		'after_title'   => '</h4>',
	) );
    
     register_sidebar( array(
		'name'          => esc_html__( 'Footer widgets 4', 'devfly' ),
		'id'            => 'sidebar-footer4',
		'description'   => esc_html__( 'Add widgets here.', 'devfly' ),
		'before_widget' => '<section id="%1$s" class="widget %2$s">',
		'after_widget'  => '</section>',
		'before_title'  => '<h4>',
		'after_title'   => '</h4>',
	) );    
}
add_action( 'widgets_init', 'main_multi_themedavfly1_widgets_init' );

function devfly_web_widgets_register() {
	require get_template_directory() . '/inc/widgets/social.php';
    require get_template_directory() . '/inc/widgets/subscribe.php';
}
add_action( 'widgets_init', 'devfly_web_widgets_register' );

/* Featured image */
add_image_size( 'themedavfly1_recent_post', 360, 240,  array( 'top', 'center' ) );


function strip_shortcode_gallery( $content ) {
    preg_match_all( '/' . get_shortcode_regex() . '/s', $content, $matches, PREG_SET_ORDER );

    if ( ! empty( $matches ) ) {
        foreach ( $matches as $shortcode ) {
            if ( 'gallery' === $shortcode[2] ) {
                $pos = strpos( $content, $shortcode[0] );
                if( false !== $pos ) {
                    return substr_replace( $content, '', $pos, strlen( $shortcode[0] ) );
                }
            }
        }
    }

    return $content;
}


//<-------------------- Recent Post Widget with Thumbnails -------------------------->

class thirst_WP_Widget_Recent_Posts extends WP_Widget {

function __construct() {
 $widget_ops = array('classname' => 'widget_recent_entries', 'description' => __( "The most recent posts on your site with thumbnails", 'devfly') );
 parent::__construct('thirst-recent-posts', __('Devfly - Recent Posts', 'devfly'), $widget_ops);
 $this->alt_option_name = 'widget_recent_entries';

add_action( 'save_post', array($this, 'flush_widget_cache') );
 add_action( 'deleted_post', array($this, 'flush_widget_cache') );
 add_action( 'switch_theme', array($this, 'flush_widget_cache') );
 }

function widget($args, $instance) {
 $cache = wp_cache_get('widget_recent_posts', 'widget');

if ( !is_array($cache) )
 $cache = array();

if ( ! isset( $args['widget_id'] ) )
 $args['widget_id'] = $this->id;

if ( isset( $cache[ $args['widget_id'] ] ) ) {
 echo $cache[ $args['widget_id'] ];
 return;
 }

ob_start();
 extract($args);

$title = apply_filters('widget_title', empty($instance['title']) ? __('Recent Posts', 'devfly') : $instance['title'], $instance, $this->id_base);
 if ( empty( $instance['number'] ) || ! $number = absint( $instance['number'] ) )
 $number = 10;
 $show_date = isset( $instance['show_date'] ) ? $instance['show_date'] : false;

$r = new WP_Query( apply_filters( 'widget_posts_args', array( 'posts_per_page' => $number, 'no_found_rows' => true, 'post_status' => 'publish', 'ignore_sticky_posts' => true, 'category__not_in' => array(23,24,25,26,27) ) ) );
 if ($r->have_posts()) :
?>
 <?php echo $before_widget; ?>
 <?php if ( $title ) echo $before_title . $title . $after_title; ?>


          <ul class="media-list main-list">
              <?php while ( $r->have_posts() ) : $r->the_post(); ?>
            <li class="media"> <a class="pull-left no-pddig" href="<?php the_permalink() ?>">
                
                <?php add_image_size( 'travel_recent_post', 360, 240,  array( 'top', 'center' ) );the_post_thumbnail('travel_recent_post');?></a>
              <div class="media-body">
                <p class="media-heading"><a href="<?php the_permalink() ?>"> <?php if ( get_the_title() ) {
 $title = get_the_title();
 echo substr($title, 0,40);
 }
 else the_ID(); ?></a></p>
                  <?php if ( $show_date ) : ?>
                <p class="dter"><?php echo get_the_date(); ?></p>
                   <?php endif;

 //thirst_number_comments();

 ?>
              </div>
            </li>
            <?php endwhile; ?>

              
 <?php echo $after_widget; ?>
<?php
 // Reset the global $the_post as this query will have stomped on it
 wp_reset_postdata();

endif;

$cache[$args['widget_id']] = ob_get_flush();
 wp_cache_set('widget_recent_posts', $cache, 'widget');
 }

function update( $new_instance, $old_instance ) {
 $instance = $old_instance;
 $instance['title'] = strip_tags($new_instance['title']);
 $instance['number'] = (int) $new_instance['number'];
 $instance['show_date'] = (bool) $new_instance['show_date'];
 $this->flush_widget_cache();

$alloptions = wp_cache_get( 'alloptions', 'options' );
 if ( isset($alloptions['widget_recent_entries']) )
 delete_option('widget_recent_entries');

return $instance;
 }

function flush_widget_cache() {
 wp_cache_delete('widget_recent_posts', 'widget');
 }

function form( $instance ) {
 $title = isset( $instance['title'] ) ? esc_attr( $instance['title'] ) : '';
 $number = isset( $instance['number'] ) ? absint( $instance['number'] ) : 5;
 $show_date = isset( $instance['show_date'] ) ? (bool) $instance['show_date'] : false;
?>
 <p><label for="<?php echo $this->get_field_id( 'title' ); ?>"><?php _e( 'Title:', 'devfly' ); ?></label>
 <input id="<?php echo $this->get_field_id( 'title' ); ?>" name="<?php echo $this->get_field_name( 'title' ); ?>" type="text" value="<?php echo $title; ?>" /></p>

<p><label for="<?php echo $this->get_field_id( 'number' ); ?>"><?php _e( 'Number of posts to show:', 'devfly' ); ?></label>
 <input id="<?php echo $this->get_field_id( 'number' ); ?>" name="<?php echo $this->get_field_name( 'number' ); ?>" type="text" value="<?php echo $number; ?>" size="3" /></p>

<p><input type="checkbox" <?php checked( $show_date ); ?> id="<?php echo $this->get_field_id( 'show_date' ); ?>" name="<?php echo $this->get_field_name( 'show_date' ); ?>" />
 <label for="<?php echo $this->get_field_id( 'show_date' ); ?>"><?php _e( 'Display post date?', 'devfly' ); ?></label></p>
<?php
 }
}
function thirst_WP_Widget_Recent_Posts() {
 // define widget title and description
 $widget_ops = array('classname' => 'widget_recent_entries', 'description' => __( "The most recent posts on your site with thumbnails", 'devfly') );
 // register the widget
 $this->WP_Widget('thirst-recent-posts', __('Devfly - Recent Posts', 'devfly'), $widget_ops);
 }
function thirst_WP_Widget_Recent_Posts_init()
{
 register_widget('thirst_WP_Widget_Recent_Posts');
}
add_action('widgets_init','thirst_WP_Widget_Recent_Posts_init');

/**
 * Enqueue scripts and styles.
 */

function main_multi_themedavfly1_styles(){
    
    wp_enqueue_style( 'devfly-bootstrap',get_template_directory_uri().'/css/bootstrap.min.css');
    wp_enqueue_style( 'devfly-font-awesome',get_template_directory_uri().'/css/font-awesome.min.css');
    wp_enqueue_style( 'devfly-animate',get_template_directory_uri().'/css/animate.css');  
    wp_enqueue_style( 'devfly-owl-carousel',get_template_directory_uri().'/css/owl.carousel.css');   
    wp_enqueue_style( 'devfly-owl-theme',get_template_directory_uri().'/css/owl.theme.css');
    wp_enqueue_style( 'devfly-jquery-fancybox',get_template_directory_uri().'/css/jquery.fancybox.css');
    wp_enqueue_style( 'devfly-lightbox',get_template_directory_uri().'/css/lightbox.css');   
    wp_enqueue_style( 'devfly-font-googleapis','http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic');
    wp_enqueue_style( 'devfly-font-googleapis-main','http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400');
}
add_action( 'wp_enqueue_scripts', 'main_multi_themedavfly1_styles' );


function main_multi_themedavfly1_scripts() {
	wp_enqueue_style( 'devfly-style', get_stylesheet_uri() );
	wp_enqueue_script( 'devfly-navigation', get_template_directory_uri() . '/js/navigation.js', array(), '20151215', true );
	wp_enqueue_script( 'devfly-skip-link-focus-fix', get_template_directory_uri() . '/js/skip-link-focus-fix.js', array(), '20151215', true );
	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}
    wp_enqueue_script( 'devfly-modernizr-custom', get_template_directory_uri() . '/js/modernizr.custom.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-jquery', get_template_directory_uri() . '/js/jquery.1.11.1.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-bootstrap', get_template_directory_uri() . '/js/bootstrap.js', array(), '20151215', true ); 
    wp_enqueue_script( 'devfly-SmoothScroll', get_template_directory_uri() . '/js/SmoothScroll.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-jquery-isotope', get_template_directory_uri() . '/js/jquery.isotope.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-owl-carousel', get_template_directory_uri() . '/js/owl.carousel.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-main', get_template_directory_uri() . '/js/main.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-flickity-pkgd-min', get_template_directory_uri() . '/js/flickity.pkgd.min.js', array(), '20151215', true );
    wp_enqueue_script( 'devfly-jquery-fancybox-pack', get_template_directory_uri() . '/js/jquery.fancybox.pack.js', array(), '20151215', true );
     wp_enqueue_script( 'devfly-jquery-waypoints-min', get_template_directory_uri() . '/js/waypoints.min.js', array(), '20151215', true );
    /*navigation*/
   
}
add_action( 'wp_enqueue_scripts', 'main_multi_themedavfly1_scripts' );


/**
 * Implement the Custom Header feature.
 */
require get_template_directory() . '/inc/custom-header.php';

/**
 * Custom template tags for this theme.
 */
require get_template_directory() . '/inc/template-tags.php';

/**
 * Custom functions that act independently of the theme templates.
 */
require get_template_directory() . '/inc/extras.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/inc/customizer.php';

/**
 * Load Jetpack compatibility file.
 */
require get_template_directory() . '/inc/jetpack.php';

require get_template_directory() . '/inc/navwalker.php';