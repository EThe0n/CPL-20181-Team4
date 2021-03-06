import Spdy = require("spdy");
import ORM = require("typeorm");
import Express = require("express");
import CookieParser = require("cookie-parser");
import BodyParser = require("body-parser");
import Exession = require("express-session");
import Passport = require("passport");
import Logger from "jj-log";

import { SETTINGS, getProjectData, getEncrypted } from "./System";

export let DB:ORM.Connection;
export const runPassport = (App:Express.Application) => {
  App.use(CookieParser(SETTINGS['cookie-secret']));
  App.use(BodyParser.json());
  App.use(BodyParser.urlencoded({ extended: true }));
  App.use(Exession({
    secret: SETTINGS['cookie-secret'],
    resave: true,
    saveUninitialized: true
  }));
  App.use(Passport.initialize());
  App.use(Passport.session());

  Passport.serializeUser<JJWAK.DB.User, JJWAK.DB.User>((user, next) => {
    next(null, user);
  });
  Passport.deserializeUser<JJWAK.DB.User, JJWAK.DB.User>((user, next) => {
    next(null, user);
  });
};
export const runWebServer = (App:Express.Application) => {
  const SPDY_OPTIONS:Spdy.server.ServerOptions = SETTINGS['https'] ? {
    key: getProjectData(SETTINGS['https']['key']),
    cert: getProjectData(SETTINGS['https']['cert'])
  } : null;
  
  if(SPDY_OPTIONS){
    Spdy.createServer(SPDY_OPTIONS, App).listen(SETTINGS['port'], () => {
      Logger.success("HTTPS Server");
    });
  }else{
    App.listen(SETTINGS['port'], () => {
      Logger.success("HTTP Server");
    });
  }
};