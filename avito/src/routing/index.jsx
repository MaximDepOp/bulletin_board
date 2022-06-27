import React from "react";
import { Route, Routes } from "react-router-dom";
import { Layout } from "@layout";
import { Home } from "@pages/Home";
import Ad from "../pages/Ad";

const AppRoutes = () => {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/ad/:id" element={<Ad />} />
      </Routes>
    </Layout>
  );
};

export default AppRoutes;
