<?php
 $user_ids = themedavfly1_get_section_choose_plan();

?>
<?php
    if ( ! empty( $user_ids ) ) {
      $n = 0;
      foreach ( $user_ids as $member ) {
        $member = wp_parse_args( $member, array(
                                'user_id'  =>array(),
                            ));
       // $link = isset( $member['link'] ) ?  $member['link'] : '';
        $feature_title = isset( $member['user_id'] ) ?  $member['user_id'] : '';
        $feature_one = isset( $member['feature_one'] ) ?  $member['feature_one'] : '';
        $feature_two = isset( $member['feature_two'] ) ?  $member['feature_two'] : '';
        $feature_three = isset( $member['feature_three'] ) ?  $member['feature_three'] : '';
        $feature_four = isset( $member['feature_four'] ) ?  $member['feature_four'] : '';
        $feature_amt= isset( $member['feature_amt'] ) ?  $member['feature_amt'] : '';  
          
        $feature_one_title = isset( $member['feature_one_title'] ) ?  $member['feature_one_title'] : '';   
        $feature_two_title = isset( $member['feature_two_title'] ) ?  $member['feature_two_title'] : '';
        $feature_three_title = isset( $member['feature_three_title'] ) ?  $member['feature_three_title'] : '';
        $feature_four_title = isset( $member['feature_four_title'] ) ?  $member['feature_four_title'] : '';
        $feature_month= isset( $member['feature_month'] ) ?  $member['feature_month'] : '';  
        $feature_selection= isset( $member['feature_selection'] ) ?  $member['feature_selection'] : '';
        $feature_selection_url= isset( $member['feature_selection_url'] ) ?  $member['feature_selection_url'] : '';  

        ?>

        <div class="col-md-4">
        <div class="plan-box">
          <h3><?php echo esc_html( $feature_title ); ?></h3>
          <ul>
            <li> <span><?php echo esc_html( $feature_one_title ); ?></span>
              <p><?php echo esc_html( $feature_one ); ?></p>
            </li>
            <li> <span><?php echo esc_html( $feature_two_title ); ?></span>
              <p><?php echo esc_html( $feature_two ); ?></p>
            </li>
            <li> <span><?php echo esc_html( $feature_three_title ); ?></span>
              <p><?php echo esc_html( $feature_three ); ?></p>
            </li>
            <li> <span><?php echo esc_html( $feature_four_title ); ?></span>
              <p><?php echo esc_html( $feature_four ); ?></p>
            </li>
          </ul>
          <p class="plan-price"><span><?php echo esc_html( $feature_amt ); ?></span>
              <?php if($feature_month !=''){?>  / <?php }?> <?php echo esc_html( $feature_month ); ?> </p>
          <a href="<?php echo esc_html($feature_selection_url);?>"><?php echo esc_html( $feature_selection ); ?></a> </div>
      </div>
   

<?php
   // }
  } // end foreach
}
else
{?>
                
       <!--plan box1-->
      <div class="col-md-4">
        <div class="plan-box">
          <h3>START</h3>
          <ul>
            <li> <span>feature one</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature two</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature three</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature four</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
          </ul>
          <p class="plan-price"><span>$100</span>/month</p>
          <a href="#">choose</a> </div>
      </div>
      <!--/plan box1--> 
      
      <!--plan box2-->
      <div class="col-md-4">
        <div class="plan-box center-box">
          <h3>medium</h3>
          <ul>
            <li> <span>feature one</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature two</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature three</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature four</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
          </ul>
          <p class="plan-price"><span>$200</span>/month</p>
          <a href="#">choose</a> </div>
      </div>
      <!--/plan box2--> 
      
      <!--plan box3-->
      <div class="col-md-4">
        <div class="plan-box">
          <h3>pro</h3>
          <ul>
            <li> <span>feature one</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature two</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature three</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
            <li> <span>feature four</span>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros</p>
            </li>
          </ul>
          <p class="plan-price"><span>$500</span>/month</p>
          <a href="#">choose</a> </div>
      </div>
      <!--/plan box3--> 
                
<?php  }?>
