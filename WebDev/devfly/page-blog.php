<?php
/*
	Template Name: Blog Listing
*/

get_header(); ?>
<!--banner content-->
<section id="top-banner" class="container-fluid">
  <div class="row"> 
    <!--banner content box-->
    <?php      
       $devfly_featured_img_url = wp_get_attachment_url(get_post_thumbnail_id(get_the_id())); 
      ?>  
    <div class="col-md-12 col-sm-12 col-xs-12 content-box nopadding text-center" style="background:url(<?php echo esc_url($devfly_featured_img_url); ?>) rgba(0,0,0,0.5) no-repeat; background-attachment:fixed; background-size:cover;" >
      <div class="texture-overlay2"></div>
        <h1><?php the_title(); ?></h1>
    </div>
    <!--/banner content box-->    
  </div>
</section>
<!--/banner content-->
<div class="clearfix"></div>
<section id="If-blog-inn">
  <div class="container ">
    <div class="row">       
      <!--=================blog section-->
      <div class="col-md-9 col-sm-8 blog-art  single-articl text-center"> 
<?php
$blog_items = get_post_meta($post->ID, '_kad_blog_items', true);
if ($blog_items == 'all')
	{
	$blog_items = '-1';
	}
$paged = (get_query_var('paged')) ? get_query_var('paged') : 1;
$temp = $wp_query;
$blog_cat_slug = null;
$wp_query = null;
$wp_query = new WP_Query();
$wp_query->query(array(
	'paged' => $paged,
	'category_name' => $blog_cat_slug,
	'posts_per_page' => $blog_items
));
if ($wp_query)
	{
	while ($wp_query->have_posts()):
		$wp_query->the_post();
?>
        <!--Blog box-->
        <div class="col-md-6 blog-article-box">
          <article> 
              <?php the_post_thumbnail('themedavfly1_recent_post'); ?>
            <div class="article-content">
              <a href="<?php the_permalink();?>"><h2><?php $words=get_the_title(); echo  $words; ?></h2></a>
              <p><?php $content=get_the_content();
             echo  $trimmed = wp_trim_words( $content, $num_words = 15, $more = null ); ?></p>
              <header class="entry-header"> <span class="byline"><span class="author vcard"><?php echo get_avatar( get_the_author_meta('ID'), 40); ?><a href="#"><?php get_the_author_meta('display_name');?></a></span></span><span class="date-article"><?php echo get_the_date(); ?></span> </header>
              <a class="btn btn-default text-center" href="<?php the_permalink();?>">read more</a> </div>
          </article>
        </div>
        <!--/Blog box--> 
        <?php endwhile;}else{?>      
          
        <div class="col-md-6 blog-article-box">
			<p>No posts found.</p>
        </div>	
        <?php }?>
		      <!--=================/blog section--> 
	<div class="clearfix"></div>
				<div class="post-pagination">
					<div class="pagination-left">
						<?php next_posts_link( __( '&laquo; Previous Page', 'devfly' ) ); ?>
					</div>
					<div class="pagination-right">
						<?php previous_posts_link( __( 'Next Page &raquo;', 'devfly' ) ); ?>
					</div>
				</div>
      </div>
   <!--=========Sidebar -->
      <aside  class="col-md-3">         
        <?php get_sidebar();?>        
      </aside >
    </div>
  </div>
</section>
<?php
get_footer(); ?>