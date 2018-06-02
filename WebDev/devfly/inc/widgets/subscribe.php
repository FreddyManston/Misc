<?php 


/**** image button ****/

add_action('admin_enqueue_scripts', 'devfly_premium_sub_widget_scripts');

function devfly_premium_sub_widget_scripts(){

    wp_enqueue_media();

    wp_enqueue_script( 'devfly_premium_sub_widget_scripts', get_template_directory_uri() . '/js/widget.js', false, '1.0', true );

}

class Devfly_Premium_Sub extends WP_Widget{

    /**
     * Register widget with WordPress.
     */
    function __construct() 
    {
        parent::__construct(
            'service-widget', // Base ID
            esc_attr__( 'Devfly - Subscribe widget', 'devfly' ), // Name
            array( 
                'description' => esc_attr__( 'Display a Service or Feature description.', 'devfly' ),
            )
        );
    }
    
    /* *front-end widget form.
    front page view */
    public function widget( $args, $instance ){


    echo $args['before_widget'];

  ?>

            <h4><?php if( !empty( $instance['title'] ) ): echo apply_filters( 'widget_title', $instance['title'] ); endif; ?></h4>
            <form class="form" method="post"  action="<?php if ($themedavfly1_footer_newsletter_mailchimp != '') echo $themedavfly1_footer_newsletter_mailchimp; ?>" target="_blank">
              <div class="form-group">
                <input type="email" placeholder="Your Email Address" class="form-control" />
              </div>
              
              <div class="form-group" >
                <button class="btn btn-default btn-block "><i class="fa fa-paper-plane"></i></button>
              </div>
            </form>
              
            <p class="small info"><i class="glyphicon glyphicon-lock"  ></i> &nbsp; Your email address is safe with us.</p>
            
              <?php 
                    if( !empty($instance['text']) ):
                    
                        echo '<p>';
                            $wp_kses_args = array(
                                'br' => array(),
                                'em' => array(),
                                'strong' => array(),
                            );
                            echo htmlspecialchars_decode( wp_kses( apply_filters( 'widget_title', $instance['text'] ), $wp_kses_args ) );
                        echo '</p>';
                    endif;
                    ?>  
 
            

        <?php

        echo $args['after_widget'];

    }
    
    
   
    /**
     * Sanitize widget form values as they are saved.
     *
     * @see WP_Widget::update()
     *
     * @param array $new_instance Values just sent to be saved.
     * @param array $old_instance Previously saved values from database.
     *
     * @return array Updated safe values to be saved.
     */
   /* public function update( $new_instance, $old_instance ) {

        $instance = $old_instance;

        $instance['text'] = stripslashes(wp_filter_post_kses($new_instance['text']));

        $instance['title'] = strip_tags($new_instance['title']);
		
		$instance['link_title'] = strip_tags( $new_instance['link_title'] );

        $instance['link'] = strip_tags( $new_instance['link'] );

        $instance['image_uri'] = strip_tags($new_instance['image_uri']);

        return $instance;

    }
*/


    
    
    /**
     * Back-end widget form.
     *
     * @see WP_Widget::form()
     *
     * @param array $instance Previo /**
     * Sanitize widget form values as they are saved.
     *
     * @see WP_Widget::update()
     *
     * @param array $new_instance Values just sent to be saved.
     * @param array $old_instance Previously saved values from database.
     *
     * @return array Updated safe values to be saved.
     */
   /* public function update( $new_instance, $old_instance ) {

        $instance = $old_instance;

        $instance['text'] = stripslashes(wp_filter_post_kses($new_instance['text']));

        $instance['title'] = strip_tags($new_instance['title']);
		
		$instance['link_title'] = strip_tags( $new_instance['link_title'] );

        $instance['link'] = strip_tags( $new_instance['link'] );

        $instance['image_uri'] = strip_tags($new_instance['image_uri']);

        return $instance;

    }
*/


    
    
    /**
     * Back-end widget form.
     *
     * @see WP_Widget::form()
     *
     * @param array $instance Previously saved values from database.
     */
    public function form( $instance ) {

        ?>
        

        <p>

            <label for="<?php echo $this->get_field_id('title'); ?>"><?php esc_html_e( 'Title', 'devfly' ); ?></label><br/>

            <input type="text" name="<?php echo $this->get_field_name('title'); ?>"
                   id="<?php echo $this->get_field_id('title'); ?>" value="<?php if( !empty( $instance['title'] ) ): echo $instance['title']; endif; ?>"
                   class="widefat"/>

        </p>

        
    <?php

    }

}
register_widget( 'Devfly_Premium_Sub' );
?>