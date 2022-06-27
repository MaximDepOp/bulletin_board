import React from "react";
import Recommendation from "@ui/Recommendation";
import Slider from "@ui/Slider";
import Services from "@ui/Services";
import Categories from "@components/Categories";

export const Home = () => {
  return (
    <div className="container">
      <Categories />
      <div className="row">
        <div className="first">
          <Slider />
        </div>
        <div className="second">
          <Services />
        </div>
        <div className="third">
          <Recommendation />
        </div>
      </div>
    </div>
  );
};
